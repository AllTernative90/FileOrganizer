package classes;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class Driver implements ActionListener, ListSelectionListener, ChangeListener, DocumentListener, IConstants {

	/**
	 * @param args
	 */
	
	
	public static GUI _gui;
	public static Logik _logic;
	public static Actions _actions;
	public static OptionPanes _optionPanes;
	static Dimension screen;
	
	public static int success = 0;
	public static int failed = 0;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					_gui = new GUI();	
					_logic = new Logik();
					_actions = new Actions();
					_optionPanes = new OptionPanes();
					
					_gui.setVisible(true);
					_gui.setResizable(false);
					
					try{
					_gui.setBounds((screen.width-900)/2, (screen.height-730)/2, 900,730);
					}
					catch(Exception e){}
							
					
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
		
	}//end main()

	
	//checks what has been clicked and calls the according method
	@Override
	public void actionPerformed(ActionEvent e) {
	
		switch(e.getActionCommand()){
		
			case BTN_OPEN:
				_actions.openDir();
				break;

			//checks whether YES was chosen in the optionPane; checks if renaming was successful and shows the correct optionPane
			case BTN_RENAME:
				if(_optionPanes.renameFiles()==0){
					if(_actions.renameFiles()==false){
						_optionPanes.renameFailed();}
					else{
					_optionPanes.renameCount(success,failed);}
//					_actions.openDir();
				}
				break;
			
			case BTN_RELOADLIST:
				_actions.openDir();
				_gui.btnRemove.setEnabled(false);
				break;
				
			case BTN_REMOVE_FILE_FROM_LIST:
				_actions.removeListItem();
				break;
			
			case BTN_MOVEFILES:
				if(_optionPanes.moveFiles()==0){
					_actions.moveFiles();
				}
				break;
				
			case BTN_UNDO_LAST_RENAME:
				if(_optionPanes.undoRename()==0){
					_actions.undoRename();
				}
				break;
			
			//CHECKBOX_1 cannot be disabled
			case CHECKBOX_2:
			case CHECKBOX_4:
			case CHECKBOX_5:
				_actions.openDir();
				break;
			
			case CHECKBOX_3:
				if(_gui.chckbx3.isSelected()){
					_gui.lblSeason.setEnabled(true);
					_gui.textField_season.setEnabled(true);
				}
				else{
					_gui.lblSeason.setEnabled(false);
					_gui.textField_season.setEnabled(false);
				}
				_actions.openDir();
				break;
			
		}//end switch 
	}//end actionPerformed()
	
	
	//when an element in a JList is clicked
	@Override
	public void valueChanged(ListSelectionEvent e) {
			_actions.handleListEvent(e);
	}


	//when a mode-tab is clicked (e.g. "about")
	@Override
	public void stateChanged(ChangeEvent arg0) {
		_actions.handleTabbedPaneEvent();
	}

	
	
	//when text is entered in a textfield
	@Override
	public void changedUpdate(DocumentEvent e) {
		_actions.handleTextFieldInsert();
	}
	@Override
	public void insertUpdate(DocumentEvent e) {
		_actions.handleTextFieldInsert();
		
	}
	@Override
	public void removeUpdate(DocumentEvent e) {
		_actions.handleTextFieldInsert();
		
	}
	

}//end class


