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
	
	
	//To Do:
	//neuer modus: unterstrich in leerzeichen und umgekehrt
	//rename anpassen, dass es überall geht
	//multi selection in list
	
	
	public static GUI _gui;
	public static Logik _logik;
	public static Actions _actions;
	public static OptionPanes _optionPanes;
	static Dimension bildschirm;
	
	public static int success = 0;
	public static int failed = 0;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					_gui = new GUI();	
					_logik = new Logik();
					_actions = new Actions();
					_optionPanes = new OptionPanes();
					
					_gui.setVisible(true);
					_gui.setResizable(false);
					
					try{
					_gui.setBounds((bildschirm.width-900)/2, (bildschirm.height-730)/2, 900,730);
					}
					catch(Exception e){}
							
					
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
		
	}//end main()

	
	//entscheidet was gedrückt wurde und ruft dann die entsprechenden Aktionen auf
	@Override
	public void actionPerformed(ActionEvent e) {
	
		switch(e.getActionCommand()){
		
			case BTN_OPEN:
				_actions.openDir();
				break;

			//checkt ob das optionPane mit JA bestätigt wurde, dann wird geschaut ob der rename geklappt hat und das entsprechende Pane angezeigt
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
			
			//CHECKBOX_1 ist nicht auswählbar
			case CHECKBOX_2:
			case CHECKBOX_4:
			case CHECKBOX_5:
				_actions.openDir();
				break;
			
			case CHECKBOX_3:
				if(_gui.chckbx3.isSelected()){
					_gui.lblStaffel.setEnabled(true);
					_gui.textField_staffel.setEnabled(true);
				}
				else{
					_gui.lblStaffel.setEnabled(false);
					_gui.textField_staffel.setEnabled(false);
				}
				_actions.openDir();
				break;
			
		}//end switch 
	}//end actionPerformed()
	
	
	//beim Anklicken eines Eintrags in den JLists
	@Override
	public void valueChanged(ListSelectionEvent e) {
			_actions.handleListEvent(e);
	}


	//beim Anklicken von den Modus Tabs
	@Override
	public void stateChanged(ChangeEvent arg0) {
		_actions.handleTabbedPaneEvent();
	}

	
	
	//beim Text eingeben in ein Textfeld
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


