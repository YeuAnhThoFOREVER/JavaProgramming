package com.gamestore.page;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.gamestore.product.Game;
import com.gamestore.product.GameInit;
import com.gamestore.product.Platform;

/**
 * =================================================================
 * [AI 사용 명시 주석 - AI USE COMPLIANCE STATEMENT]
 * -----------------------------------------------------------------
 * 1. AI 사용 여부 : YES
 * 2. 사용 AI 모델 : Anthropic Claude (Opus 4.8, 2026-06 버전)
 * 3. 적용 코드 범위 : AdminPage 클래스 - 관리자 전용 상품 관리(CRUD) 화면 전체
 *    (상품 추가/수정/삭제, 재고 증가/감소 기능 및 입력 폼 대화상자)
 * 4. 사용 목적 및 사유 : 관리자 권한으로 게임 상품을 추가/수정/삭제하고
 *    재고를 조정할 수 있는 Swing 관리 화면 설계 및 입력 검증 로직 작성 지원.
 * =================================================================
 */

/** [9] 관리자 전용 상품 관리 화면(추가/수정/삭제/재고 조정). */
public class AdminPage extends JDialog {
    private static final long serialVersionUID = 1L;

    private final GameInit gameInit;
    private final DefaultTableModel model;
    private final JTable table;

    public AdminPage(Frame owner, GameInit gameInit) {
        super(owner, "관리자 - 상품 관리", true);
        this.gameInit = gameInit;

        setSize(820, 420);
        setLocationRelativeTo(owner);
        setLayout(new BorderLayout(10, 10));

        // 안내 문구(관리자 권한 표시)
        add(new JLabel("  [관리자 모드] 상품을 추가/수정/삭제하거나 재고를 조정할 수 있습니다."),
                BorderLayout.NORTH);

        String[] columns = {"ID", "제목", "플랫폼", "장르", "가격", "출시일", "재고"};
        model = new DefaultTableModel(columns, 0) {
            private static final long serialVersionUID = 1L;
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // 표는 직접 수정 불가, 버튼으로만 변경
            }
        };
        table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // 관리자 기능 버튼들
        JPanel buttons = new JPanel(new GridLayout(1, 5, 6, 6));
        JButton addButton = new JButton("상품 추가");
        addButton.addActionListener(e -> onAdd());
        JButton editButton = new JButton("상품 수정");
        editButton.addActionListener(e -> onEdit());
        JButton deleteButton = new JButton("상품 삭제");
        deleteButton.addActionListener(e -> onDelete());
        JButton restockButton = new JButton("재고 +1");
        restockButton.addActionListener(e -> onChangeStock(+1));
        JButton reduceButton = new JButton("재고 -1");
        reduceButton.addActionListener(e -> onChangeStock(-1));
        buttons.add(addButton);
        buttons.add(editButton);
        buttons.add(deleteButton);
        buttons.add(restockButton);
        buttons.add(reduceButton);

        add(new JScrollPane(table), BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);

        refresh();
        setVisible(true);
    }

    /** 표를 현재 카탈로그 내용으로 다시 그린다. */
    private void refresh() {
        model.setRowCount(0);
        for (Game g : gameInit.getGames()) {
            model.addRow(new Object[] {
                g.getId(),
                g.getTitle(),
                g.getPlatform().getLabel(),
                g.getGenre(),
                String.format("₩%,d", g.getPrice()),
                g.getReleaseDate(),
                g.getStock()
            });
        }
    }

    /** 선택된 행의 Game 을 반환한다. 선택이 없으면 경고 후 null. */
    private Game getSelectedGame() {
        int row = table.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "상품을 선택해 주세요.",
                    "경고", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        String id = (String) table.getValueAt(row, 0);
        return gameInit.findById(id);
    }

    /** [추가] 입력 폼을 띄워 새 상품을 카탈로그에 등록한다. */
    private void onAdd() {
        Game created = showProductForm(null);
        if (created == null) {
            return; // 취소 또는 입력 오류
        }
        if (gameInit.existsId(created.getId())) {
            JOptionPane.showMessageDialog(this, "이미 존재하는 상품 ID 입니다.",
                    "추가 실패", JOptionPane.ERROR_MESSAGE);
            return;
        }
        gameInit.addGame(created);
        refresh();
        JOptionPane.showMessageDialog(this, "새 상품을 추가했습니다.",
                "알림", JOptionPane.INFORMATION_MESSAGE);
    }

    /** [수정] 선택한 상품의 정보를 폼으로 불러와 변경한다. */
    private void onEdit() {
        Game target = getSelectedGame();
        if (target == null) {
            return;
        }
        Game edited = showProductForm(target);
        if (edited == null) {
            return;
        }
        // ID 는 그대로 두고 나머지 속성만 갱신한다.
        target.setTitle(edited.getTitle());
        target.setPrice(edited.getPrice());
        target.setPlatform(edited.getPlatform());
        target.setGenre(edited.getGenre());
        target.setReleaseDate(edited.getReleaseDate());
        target.setStock(edited.getStock());
        refresh();
        JOptionPane.showMessageDialog(this, "상품 정보를 수정했습니다.",
                "알림", JOptionPane.INFORMATION_MESSAGE);
    }

    /** [삭제] 선택한 상품을 카탈로그에서 제거한다. */
    private void onDelete() {
        Game target = getSelectedGame();
        if (target == null) {
            return;
        }
        int answer = JOptionPane.showConfirmDialog(this,
                "정말 '" + target.getTitle() + "' 상품을 삭제하시겠습니까?",
                "삭제 확인", JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.YES_OPTION) {
            gameInit.removeById(target.getId());
            refresh();
            JOptionPane.showMessageDialog(this, "상품을 삭제했습니다.",
                    "알림", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /** [재고] 선택한 상품의 재고를 delta(+1/-1)만큼 조정한다. */
    private void onChangeStock(int delta) {
        Game target = getSelectedGame();
        if (target == null) {
            return;
        }
        int newStock = target.getStock() + delta;
        if (newStock < 0) {
            JOptionPane.showMessageDialog(this, "재고는 0개 미만이 될 수 없습니다.",
                    "알림", JOptionPane.WARNING_MESSAGE);
            return;
        }
        target.setStock(newStock);
        refresh();
    }

    /**
     * 상품 입력/수정 폼 대화상자를 띄운다.
     * @param base 수정 대상(추가일 때는 null)
     * @return 입력된 값으로 만든 Game, 취소/오류 시 null
     */
    private Game showProductForm(Game base) {
        boolean isEdit = (base != null);

        JTextField idField = new JTextField(isEdit ? base.getId() : "");
        idField.setEditable(!isEdit); // 수정 시 ID 변경 불가
        JTextField titleField = new JTextField(isEdit ? base.getTitle() : "");
        JComboBox<Platform> platformBox = new JComboBox<>(Platform.values());
        if (isEdit) {
            platformBox.setSelectedItem(base.getPlatform());
        }
        JTextField genreField = new JTextField(isEdit ? base.getGenre() : "");
        JTextField priceField = new JTextField(isEdit ? String.valueOf(base.getPrice()) : "");
        JTextField dateField = new JTextField(isEdit ? base.getReleaseDate() : "");
        JTextField stockField = new JTextField(isEdit ? String.valueOf(base.getStock()) : "");

        JPanel form = new JPanel(new GridLayout(7, 2, 6, 6));
        form.add(new JLabel("상품 ID:"));        form.add(idField);
        form.add(new JLabel("제목:"));           form.add(titleField);
        form.add(new JLabel("플랫폼:"));         form.add(platformBox);
        form.add(new JLabel("장르:"));           form.add(genreField);
        form.add(new JLabel("가격(원):"));       form.add(priceField);
        form.add(new JLabel("출시일(yyyy-MM-dd):")); form.add(dateField);
        form.add(new JLabel("재고:"));           form.add(stockField);

        int result = JOptionPane.showConfirmDialog(this, form,
                isEdit ? "상품 수정" : "상품 추가",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result != JOptionPane.OK_OPTION) {
            return null; // 취소
        }

        // 입력값 검증
        String id = idField.getText().trim();
        String title = titleField.getText().trim();
        String genre = genreField.getText().trim();
        String date = dateField.getText().trim();
        if (id.isEmpty() || title.isEmpty()) {
            JOptionPane.showMessageDialog(this, "상품 ID 와 제목은 필수입니다.",
                    "입력 오류", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        int price;
        int stock;
        try {
            price = Integer.parseInt(priceField.getText().trim());
            stock = Integer.parseInt(stockField.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "가격과 재고는 숫자로 입력해 주세요.",
                    "입력 오류", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        if (price < 0 || stock < 0) {
            JOptionPane.showMessageDialog(this, "가격과 재고는 0 이상이어야 합니다.",
                    "입력 오류", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        Platform platform = (Platform) platformBox.getSelectedItem();
        return new Game(id, title, price, platform, genre, date, stock);
    }
}
