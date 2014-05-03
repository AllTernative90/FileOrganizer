package classes;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class GUI extends JFrame implements IConstants{

	public JPanel contentPane,panel_brackets, panel_tvshow_inner, panel_about_inner;
	public JTextField textField_prefix, textField_staffel, textField_folderpath;
	JScrollPane scrollPane, scrollPane2;
	JButton btnOpen ,btnMoveFiles, btnReload, btnRename, btnRemove, btnUndo;
	public JLabel lblStaffel,lblPrefix, lblRenameCriteria, lblCurrentFilenames, lblFileCount,lblNewFilenames;
	public JCheckBox chckbx1, chckbx5, chckbx2,chckbx3,chckbx4;
	public JList<String> list,list2;
	JTabbedPane tabbedPane;
	DefaultListModel<String> listmodel, listmodel2;

	
	
	
	public GUI() {
		setTitle(PROGRAM_TITLE);
		
		//look and feel
		 try {
			UIManager.setLookAndFeel(
			            UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		 
		 
		 
		 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 729);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		sl_contentPane.putConstraint(SpringLayout.WEST, tabbedPane, 5, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, tabbedPane, 300, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, tabbedPane, -5, SpringLayout.EAST, contentPane);
		contentPane.add(tabbedPane);
		
		JPanel panel_about = new JPanel();
		tabbedPane.addTab(TAB_ABOUT, null, panel_about, TAB_ABOUT_DESC);
		panel_about.setLayout(new BoxLayout(panel_about, BoxLayout.X_AXIS));
		
		panel_about_inner = new JPanel();
		panel_about_inner.setPreferredSize(new Dimension(0, 250));   
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setViewportView(panel_about_inner);
		SpringLayout sl_panel = new SpringLayout();
		panel_about_inner.setLayout(sl_panel);
		
	
			
				
		JLabel lblThisProgramIs = new JLabel(PROGRAM_INFO);
		sl_panel.putConstraint(SpringLayout.NORTH, lblThisProgramIs, 5, SpringLayout.NORTH, panel_about_inner);
		sl_panel.putConstraint(SpringLayout.WEST, lblThisProgramIs, 10, SpringLayout.WEST, panel_about_inner);
		panel_about_inner.add(lblThisProgramIs);
		lblThisProgramIs.setBounds(0, 0, 838, 175);
		//		panel_about.add(panel_about_inner);
		
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel_about.add(scrollPane_2);
		
	
		
		JPanel panel_tvshow = new JPanel();
		tabbedPane.addTab(TAB_TVSHOW, null, panel_tvshow, TAB_TVSHOW_DESC);
		panel_tvshow.setLayout(new BoxLayout(panel_tvshow, BoxLayout.X_AXIS));
		
		panel_tvshow_inner = new JPanel();
		panel_tvshow.add(panel_tvshow_inner);
		SpringLayout sl_panel_tvshow_inner = new SpringLayout();
		panel_tvshow_inner.setLayout(sl_panel_tvshow_inner);
		
		
		lblPrefix = new JLabel(LBL_TVSHOW_NAME);
		sl_panel_tvshow_inner.putConstraint(SpringLayout.NORTH, lblPrefix, 20, SpringLayout.NORTH, panel_tvshow_inner);
		sl_panel_tvshow_inner.putConstraint(SpringLayout.WEST, lblPrefix, 10, SpringLayout.WEST, panel_tvshow_inner);
		panel_tvshow_inner.add(lblPrefix);
		
		textField_prefix = new JTextField();
		sl_panel_tvshow_inner.putConstraint(SpringLayout.NORTH, textField_prefix, 10, SpringLayout.SOUTH, lblPrefix);
		sl_panel_tvshow_inner.putConstraint(SpringLayout.WEST, textField_prefix, 0, SpringLayout.WEST, lblPrefix);
		panel_tvshow_inner.add(textField_prefix);
		textField_prefix.setColumns(10);
		textField_prefix.setAlignmentY(0.0f);
		textField_prefix.setAlignmentX(0.0f);
		
		lblStaffel = new JLabel(LBL_SEASON);
		lblStaffel.setEnabled(false);
		sl_panel_tvshow_inner.putConstraint(SpringLayout.NORTH, lblStaffel, 20, SpringLayout.SOUTH, textField_prefix);
		sl_panel_tvshow_inner.putConstraint(SpringLayout.WEST, lblStaffel, 0, SpringLayout.WEST, textField_prefix);
		panel_tvshow_inner.add(lblStaffel);
		
		textField_staffel = new JTextField();
		textField_staffel.setEnabled(false);
		sl_panel_tvshow_inner.putConstraint(SpringLayout.NORTH, textField_staffel, 10, SpringLayout.SOUTH, lblStaffel);
		sl_panel_tvshow_inner.putConstraint(SpringLayout.WEST, textField_staffel, 0, SpringLayout.WEST, lblStaffel);
		sl_panel_tvshow_inner.putConstraint(SpringLayout.EAST, textField_staffel, 0, SpringLayout.EAST, lblStaffel);
		panel_tvshow_inner.add(textField_staffel);
		textField_staffel.setColumns(10);
		textField_staffel.setAlignmentY(0.0f);
		textField_staffel.setAlignmentX(0.0f);
		
		lblRenameCriteria = new JLabel(LBL_TVSHOW_CRITERIA);
		sl_panel_tvshow_inner.putConstraint(SpringLayout.NORTH, lblRenameCriteria, 0, SpringLayout.NORTH, lblPrefix);
		sl_panel_tvshow_inner.putConstraint(SpringLayout.WEST, lblRenameCriteria, 250, SpringLayout.EAST, lblPrefix);
		panel_tvshow_inner.add(lblRenameCriteria);
		
		
		JPanel panel_tvshow_inner_criteria = new JPanel();
		sl_panel_tvshow_inner.putConstraint(SpringLayout.EAST, textField_prefix, -20, SpringLayout.WEST, panel_tvshow_inner_criteria);
		sl_panel_tvshow_inner.putConstraint(SpringLayout.NORTH, panel_tvshow_inner_criteria, 10, SpringLayout.SOUTH, lblRenameCriteria);
		sl_panel_tvshow_inner.putConstraint(SpringLayout.WEST, panel_tvshow_inner_criteria, 0, SpringLayout.WEST, lblRenameCriteria);
		sl_panel_tvshow_inner.putConstraint(SpringLayout.SOUTH, panel_tvshow_inner_criteria, -20, SpringLayout.SOUTH, panel_tvshow_inner);
		sl_panel_tvshow_inner.putConstraint(SpringLayout.EAST, panel_tvshow_inner_criteria, -10, SpringLayout.EAST, panel_tvshow_inner);
		panel_tvshow_inner.add(panel_tvshow_inner_criteria);
		panel_tvshow_inner_criteria.setForeground(Color.BLACK);
		panel_tvshow_inner_criteria.setBorder(new LineBorder(Color.LIGHT_GRAY));
		SpringLayout sl_panel_tvshow_inner_criteria = new SpringLayout();
		panel_tvshow_inner_criteria.setLayout(sl_panel_tvshow_inner_criteria);
		
	
		
		chckbx1 = new JCheckBox(CHECKBOX_1);
		chckbx1.setEnabled(false);
		sl_panel_tvshow_inner_criteria.putConstraint(SpringLayout.NORTH, chckbx1, 10, SpringLayout.NORTH, panel_tvshow_inner_criteria);
		sl_panel_tvshow_inner_criteria.putConstraint(SpringLayout.WEST, chckbx1, 10, SpringLayout.WEST, panel_tvshow_inner_criteria);
		chckbx1.setSelected(true);
		panel_tvshow_inner_criteria.add(chckbx1);

		//action Listener Zeugs
		Driver myDr = new Driver();
		
		panel_brackets = new JPanel();
		tabbedPane.addTab(TAB_BRACKETS, null, panel_brackets, TAB_BRACKETS_DESC);
		panel_brackets.setLayout(new BoxLayout(panel_brackets, BoxLayout.X_AXIS));
		
		JPanel panel_brackets_inner = new JPanel();
		panel_brackets.add(panel_brackets_inner);
		panel_brackets_inner.setLayout(new SpringLayout());
		
		chckbx2 = new JCheckBox(CHECKBOX_2);
		sl_panel_tvshow_inner_criteria.putConstraint(SpringLayout.NORTH, chckbx2, 0, SpringLayout.NORTH, chckbx1);
		sl_panel_tvshow_inner_criteria.putConstraint(SpringLayout.WEST, chckbx2, 20, SpringLayout.EAST, chckbx1);
		panel_tvshow_inner_criteria.add(chckbx2);
		chckbx2.setSelected(true);
		
		chckbx3 = new JCheckBox(CHECKBOX_3);
		sl_panel_tvshow_inner_criteria.putConstraint(SpringLayout.NORTH, chckbx3, 10, SpringLayout.SOUTH, chckbx1);
		sl_panel_tvshow_inner_criteria.putConstraint(SpringLayout.WEST, chckbx3, 0, SpringLayout.WEST, chckbx1);
		panel_tvshow_inner_criteria.add(chckbx3);
		
		chckbx4 = new JCheckBox(CHECKBOX_4);
		sl_panel_tvshow_inner_criteria.putConstraint(SpringLayout.NORTH, chckbx4, 0, SpringLayout.NORTH, chckbx3);
		sl_panel_tvshow_inner_criteria.putConstraint(SpringLayout.WEST, chckbx4, 0, SpringLayout.WEST, chckbx2);
		panel_tvshow_inner_criteria.add(chckbx4);
		chckbx4.setSelected(true);
		
		chckbx5 = new JCheckBox(CHECKBOX_5);
		sl_panel_tvshow_inner_criteria.putConstraint(SpringLayout.NORTH, chckbx5, 10, SpringLayout.SOUTH, chckbx3);
		sl_panel_tvshow_inner_criteria.putConstraint(SpringLayout.WEST, chckbx5, 0, SpringLayout.WEST, chckbx3);
		panel_tvshow_inner_criteria.add(chckbx5);
		chckbx5.addActionListener(myDr);
		chckbx4.addActionListener(myDr);
		chckbx3.addActionListener(myDr);
		chckbx2.addActionListener(myDr);
		
		scrollPane = new JScrollPane();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane, 650, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane, 435, SpringLayout.WEST, contentPane);
		contentPane.add(scrollPane);
		
		
		listmodel = new DefaultListModel<String>();
		listmodel2 = new DefaultListModel<String>();
		list = new JList<String>(listmodel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);
		
	
		
		scrollPane2 = new JScrollPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane2, 0, SpringLayout.NORTH, scrollPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane2, 10, SpringLayout.EAST, scrollPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane2, 0, SpringLayout.SOUTH, scrollPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane2, -5, SpringLayout.EAST, contentPane);
		contentPane.add(scrollPane2);
		
		list2 = new JList<String>(listmodel2);
		list2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane2.setViewportView(list2);
		
		lblCurrentFilenames = new JLabel(LBL_CURRENT_FILENAMES);
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane, 5, SpringLayout.SOUTH, lblCurrentFilenames);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, lblCurrentFilenames);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblCurrentFilenames, 20, SpringLayout.SOUTH, tabbedPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblCurrentFilenames, 10, SpringLayout.WEST, contentPane);
		contentPane.add(lblCurrentFilenames);
		
			lblNewFilenames = new JLabel(LBL_NEW_FILENAMES);
			sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewFilenames, 20, SpringLayout.SOUTH, tabbedPane);
			sl_contentPane.putConstraint(SpringLayout.WEST, lblNewFilenames, 10, SpringLayout.EAST, scrollPane);
			contentPane.add(lblNewFilenames);
			
			JLabel lblFolderpath = new JLabel(LBL_FOLDERPATH);
			sl_contentPane.putConstraint(SpringLayout.NORTH, lblFolderpath, 10, SpringLayout.NORTH, contentPane);
			sl_contentPane.putConstraint(SpringLayout.WEST, lblFolderpath, 10, SpringLayout.WEST, contentPane);
			contentPane.add(lblFolderpath);
			
	
			
			textField_folderpath = new JTextField();
			sl_contentPane.putConstraint(SpringLayout.NORTH, textField_folderpath, 5, SpringLayout.SOUTH, lblFolderpath);
			sl_contentPane.putConstraint(SpringLayout.WEST, textField_folderpath, 0, SpringLayout.WEST, lblFolderpath);
			sl_contentPane.putConstraint(SpringLayout.EAST, textField_folderpath, -150, SpringLayout.EAST, contentPane);
			contentPane.add(textField_folderpath);
			textField_folderpath.setColumns(10);
			textField_folderpath.setAlignmentY(Component.TOP_ALIGNMENT);
			textField_folderpath.setAlignmentX(0.0f);
			
			btnOpen = new JButton(BTN_OPEN);
			sl_contentPane.putConstraint(SpringLayout.NORTH, tabbedPane, 20, SpringLayout.SOUTH, btnOpen);
			btnOpen.setToolTipText(BTN_OPEN_TOOLTIP);
			sl_contentPane.putConstraint(SpringLayout.NORTH, btnOpen, 5, SpringLayout.SOUTH, textField_folderpath);
			sl_contentPane.putConstraint(SpringLayout.WEST, btnOpen, 0, SpringLayout.WEST, textField_folderpath);
			contentPane.add(btnOpen);
			
			JButton btnChooseDirectory = new JButton(BTN_CHOOSE_DIR);
			sl_contentPane.putConstraint(SpringLayout.NORTH, btnChooseDirectory, 0, SpringLayout.NORTH, textField_folderpath);
			sl_contentPane.putConstraint(SpringLayout.SOUTH, btnChooseDirectory, 0, SpringLayout.SOUTH, textField_folderpath);
			btnChooseDirectory.setToolTipText(BTN_CHOOSE_DIR_TOOLTIP);
			sl_contentPane.putConstraint(SpringLayout.WEST, btnChooseDirectory, 10, SpringLayout.EAST, textField_folderpath);
			sl_contentPane.putConstraint(SpringLayout.EAST, btnChooseDirectory, -5, SpringLayout.EAST, contentPane);
			contentPane.add(btnChooseDirectory);
			btnChooseDirectory.setEnabled(false);
			
			btnMoveFiles = new JButton(BTN_MOVEFILES);
			btnMoveFiles.setToolTipText(BTN_MOVEFILES_TOOLTIP);
			sl_contentPane.putConstraint(SpringLayout.NORTH, btnMoveFiles, 0, SpringLayout.NORTH, btnOpen);
			sl_contentPane.putConstraint(SpringLayout.WEST, btnMoveFiles, 10, SpringLayout.EAST, btnOpen);
			contentPane.add(btnMoveFiles);
			btnMoveFiles.setEnabled(false);
			
			btnRename = new JButton(BTN_RENAME);
			sl_contentPane.putConstraint(SpringLayout.WEST, btnRename, 225, SpringLayout.WEST, scrollPane2);
			sl_contentPane.putConstraint(SpringLayout.EAST, btnRename, 0, SpringLayout.EAST, scrollPane2);
			btnRename.setToolTipText(BTN_RENAME_TOOLTIP);
			contentPane.add(btnRename);
			btnRename.setEnabled(false);
			btnRename.setHorizontalTextPosition(SwingConstants.CENTER);
			
			btnReload = new JButton(BTN_RELOADLIST);
			btnReload.setToolTipText(BTN_RELOADLIST_TOOLTIP);
			sl_contentPane.putConstraint(SpringLayout.WEST, btnReload, 225, SpringLayout.WEST, scrollPane);
			sl_contentPane.putConstraint(SpringLayout.EAST, btnReload, 0, SpringLayout.EAST, scrollPane);
			contentPane.add(btnReload);
			btnReload.setEnabled(false);
			btnReload.setHorizontalTextPosition(SwingConstants.CENTER);
			
			btnUndo = new JButton(BTN_UNDO_LAST_RENAME);
			btnUndo.setEnabled(false);
			sl_contentPane.putConstraint(SpringLayout.NORTH, btnRename, 0, SpringLayout.NORTH, btnUndo);
			sl_contentPane.putConstraint(SpringLayout.NORTH, btnUndo, 0, SpringLayout.NORTH, btnReload);
			sl_contentPane.putConstraint(SpringLayout.WEST, btnUndo, 0, SpringLayout.WEST, scrollPane2);
			sl_contentPane.putConstraint(SpringLayout.EAST, btnUndo, -225, SpringLayout.EAST, scrollPane2);
			contentPane.add(btnUndo);
			
			btnRemove = new JButton(BTN_REMOVE_FILE_FROM_LIST);
			sl_contentPane.putConstraint(SpringLayout.NORTH, btnRemove, 10, SpringLayout.SOUTH, scrollPane);
			sl_contentPane.putConstraint(SpringLayout.NORTH, btnReload, 0, SpringLayout.NORTH, btnRemove);
			btnRemove.setToolTipText(BTN_REMOVE_FILE_FROM_LIST_TOOLTIP);
			sl_contentPane.putConstraint(SpringLayout.EAST, btnRemove, -225, SpringLayout.EAST, scrollPane);
			btnRemove.setEnabled(false);
			sl_contentPane.putConstraint(SpringLayout.WEST, btnRemove, 0, SpringLayout.WEST, scrollPane);
			contentPane.add(btnRemove);
			
			lblFileCount = new JLabel(LBL_FILECOUNT);
			sl_contentPane.putConstraint(SpringLayout.SOUTH, lblFileCount, -5, SpringLayout.NORTH, scrollPane);
			sl_contentPane.putConstraint(SpringLayout.EAST, lblFileCount, -10, SpringLayout.EAST, scrollPane);
			lblFileCount.setForeground(Color.GRAY);
			contentPane.add(lblFileCount);
			lblFileCount.setVisible(false);
			
			
			
			
			//listener hinzufügen
			btnReload.addActionListener(myDr);
			btnRename.addActionListener(myDr);
			btnMoveFiles.addActionListener(myDr);
			btnRemove.addActionListener(myDr);
			btnOpen.addActionListener(myDr);
			btnUndo.addActionListener(myDr);
			list2.addListSelectionListener(myDr);
			list.addListSelectionListener(myDr);
			tabbedPane.addChangeListener(myDr);
			textField_prefix.getDocument().addDocumentListener(myDr);
	
		
		
	}
	
	
	//das Label mit der Anzahl der Dateien anzeigen, aktualisieren oder ausblenden
	public void updateFileCount(boolean mode){
	
		if(mode){
			lblFileCount.setVisible(true);
			lblFileCount.setText(listmodel.size() + LBL_FILES_IN_LIST);
		}
		else{
			if(listmodel.size() == 0)
				lblFileCount.setVisible(false);
		}
		
	}
	
	
	//die Liste mit alten Namen aktualisieren
	public void updateList_old(List<String> dir){

		listmodel.removeAllElements();
		
		for(String s:dir){
		    listmodel.addElement(s);
		}
		
		scrollPane.setViewportView(list);
	}//end updateList_old

	
	//die Liste mit neuen Namen aktualisieren
	public void updateList_new(List<String> dir){
		
		listmodel2.removeAllElements();
		
		for(String s:dir){
		    listmodel2.addElement(s);
		}
		
		scrollPane2.setViewportView(list2);
	}//end updateList_new
	
}//end class


