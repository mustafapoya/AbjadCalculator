package net.golbarg.abjad;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.ComponentOrientation;

import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AbjadCalculatorSwing extends JFrame {

	private JPanel contentPane;
	private JTextField txtText;
	private JTextField txtResult;
	private JTable tableDetails;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());

					AbjadCalculatorSwing frame = new AbjadCalculatorSwing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AbjadCalculatorSwing() {
		setPreferredSize(new Dimension(320, 480));
		setSize(new Dimension(320, 480));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JLabel lblAppTitle = new JLabel("Abjad Calculator");
		lblAppTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAppTitle.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblAppTitle);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);

		JLabel lblText = new JLabel("Type your text in Arabic/Persian: ");
		lblText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblText, 10, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblText, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblText, 294, SpringLayout.WEST, panel_1);

		panel_1.add(lblText);

		txtText = new JTextField();
		txtText.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		sl_panel_1.putConstraint(SpringLayout.NORTH, txtText, 6, SpringLayout.SOUTH, lblText);
		sl_panel_1.putConstraint(SpringLayout.WEST, txtText, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, txtText, 31, SpringLayout.SOUTH, lblText);
		sl_panel_1.putConstraint(SpringLayout.EAST, txtText, 0, SpringLayout.EAST, lblText);
		panel_1.add(txtText);
		txtText.setColumns(10);

		JButton btnCalculate = new JButton("Calculate");
		sl_panel_1.putConstraint(SpringLayout.NORTH, btnCalculate, 6, SpringLayout.SOUTH, txtText);
		sl_panel_1.putConstraint(SpringLayout.WEST, btnCalculate, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, btnCalculate, 36, SpringLayout.SOUTH, txtText);
		sl_panel_1.putConstraint(SpringLayout.EAST, btnCalculate, 0, SpringLayout.EAST, lblText);
		panel_1.add(btnCalculate);

		btnCalculate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String text = txtText.getText().trim();
				txtResult.setText(String.valueOf(AbjadController.calculateAbjadOf(text)));
			}
		});

		JLabel lblResult = new JLabel("Abjad Calculation of your text");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblResult, 6, SpringLayout.SOUTH, btnCalculate);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblResult, 0, SpringLayout.WEST, lblText);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblResult, 0, SpringLayout.EAST, lblText);
		lblResult.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblResult);

		txtResult = new JTextField();
		txtResult.setEditable(false);
		txtResult.setBackground(Color.LIGHT_GRAY);
		sl_panel_1.putConstraint(SpringLayout.NORTH, txtResult, 6, SpringLayout.SOUTH, lblResult);
		sl_panel_1.putConstraint(SpringLayout.WEST, txtResult, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, txtResult, 0, SpringLayout.EAST, lblText);
		txtResult.setColumns(10);
		panel_1.add(txtResult);

		JLabel lblDetail = new JLabel("Details:");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblDetail, 154, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, txtResult, -6, SpringLayout.NORTH, lblDetail);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblDetail, 0, SpringLayout.WEST, lblText);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblDetail, 0, SpringLayout.EAST, lblText);
		lblDetail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblDetail);

		JPanel panel_2 = new JPanel();
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_2, 6, SpringLayout.SOUTH, lblDetail);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_2, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_2, 240, SpringLayout.SOUTH, lblDetail);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_2, 294, SpringLayout.WEST, panel_1);
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		ArrayList<Abjad> list = AbjadController.allAbjads();

		String[][] data = new String[list.size()][2];

		for (int i = 0; i < list.size(); i++) {
			data[i][0] = String.valueOf(list.get(i).getCharacter());
			data[i][1] = String.valueOf(list.get(i).getValue());
		}

		String column[] = { "Character", "Value" };
		tableDetails = new JTable(data, column);
		tableDetails.getTableHeader().setVisible(true);

		panel_2.add(tableDetails, BorderLayout.CENTER);

	}
}
