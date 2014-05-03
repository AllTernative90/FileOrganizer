package classes;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ListSelectionEvent;

public class Actions {
	
	
	GUI _gui = (Driver._gui);
	Logik _logik = (Driver._logik);
	OptionPanes _optionPanes = (Driver._optionPanes);
	
	//Die Backups werden definiert für die Undo Funktion
	String path, path_backup;
	List<String> neuer_name = new ArrayList<String>();
	List<String> alter_name = new ArrayList<String>();
	List<String> alter_name_backup = new ArrayList<String>();
	List<String> neuer_name_backup = new ArrayList<String>();
	
	
	
	public void moveFiles(){
		File aFile = new File(path);
	    Logik.moveFiles(aFile, path);
	    _gui.btnMoveFiles.setEnabled(false);
	    openDir();
	}
	
	
	public void openDir(){
		
		if(_gui.textField_folderpath.getText().length() > 0 ){
			
			 _gui.btnMoveFiles.setEnabled(true);
			 _gui.btnReload.setEnabled(true);
			 
			 
			 boolean c2 = _gui.chckbx2.isSelected();
			 boolean c3 = _gui.chckbx3.isSelected();
			 boolean c4 = _gui.chckbx4.isSelected();
			 boolean c5 = _gui.chckbx5.isSelected();
			 
			 
			try{
				path = _gui.textField_folderpath.getText().toString();
				_gui.updateList_old(_logik.getOldNames(path));
				
				
				if (_gui.tabbedPane.getSelectedIndex() == 1){
					neuer_name=_logik.getNewNames_tv(_gui.textField_prefix.getText(), _gui.textField_staffel.getText(), _logik.getOldNames(path), c2,c3,c4,c5);
					 _gui.btnRename.setEnabled(true);
					 _gui.updateList_new(neuer_name);
				}
				
				
				if (_gui.tabbedPane.getSelectedIndex() == 2){
					neuer_name=_logik.getNewNames_song(_logik.getOldNames(path));
					 _gui.btnRename.setEnabled(true);
					 _gui.updateList_new(neuer_name);
				}
					
					
				alter_name=_logik.getOldNames(path);
				
			}
			catch(Exception e1)
			{
				 _gui.btnMoveFiles.setEnabled(false);
				 _gui.btnReload.setEnabled(false);
				 _gui.btnRename.setEnabled(false);
				 _gui.btnRemove.setEnabled(false);
				 
				
				 _gui.updateList_old(new ArrayList<String>(1));
				 _gui.updateList_new(new ArrayList<String>(1));
				 
			}
			
			_gui.updateFileCount(true);
			_gui.btnRemove.setEnabled(false);
			
		}//end if	
	}//end action_open()
	
	
	public boolean renameFiles(){

		
		if((_gui.tabbedPane.getSelectedIndex() == 1 && _gui.textField_prefix.getText().length() >0) || _gui.tabbedPane.getSelectedIndex() == 2){
		
			//Listen "speichern" für einen Undo
			path_backup = path;
			neuer_name_backup = neuer_name;
			alter_name_backup = alter_name;
			
			
			_logik.rename(path, neuer_name, alter_name);
			_gui.btnUndo.setEnabled(true);
			
			openDir();
			return true;
		}
		else 
			return false;
		
	}
	 
	
	public void removeListItem(){
		
		_gui.listmodel.removeElementAt(_gui.list.getSelectedIndex());
		_gui.listmodel2.removeElementAt(_gui.list2.getSelectedIndex());
		_gui.btnRemove.setEnabled(false);
		_gui.updateFileCount(true);
	}

	
	public void undoRename(){

		
		_logik.rename(path_backup, alter_name_backup, neuer_name_backup);
		_gui.btnUndo.setEnabled(false);
		openDir();
	}
	
	//Beim Klicken auf ein Listenelement
	public void handleListEvent(ListSelectionEvent e){
		
		if(!e.getValueIsAdjusting()){
			if(_gui.tabbedPane.getSelectedIndex() != 0 && _gui.btnRemove.isEnabled() == false && _gui.list2.getSelectedIndex() != -1){
				_gui.btnRemove.setEnabled(true);
			}
		
			if(e.getSource() == _gui.list){
				_gui.list2.setSelectedIndex(_gui.list.getSelectedIndex());
			}
			else{
				_gui.list.setSelectedIndex(_gui.list2.getSelectedIndex());
			}
		}//end if
	}//end action_listEvent()
	
	//Wenn Tab "About" gewählt wird, Buttons deaktivieren und Liste leeren
	public void handleTabbedPaneEvent(){
		
		if (_gui.tabbedPane.getSelectedIndex() == 0)
		{
			_gui.btnRename.setEnabled(false);
			_gui.btnRemove.setEnabled(false);
			_gui.listmodel2.removeAllElements();
			_gui.list.clearSelection();
			_gui.updateFileCount(false);
		}
		else{
			openDir();
		}
		
	}
	
	
	public void handleTextFieldInsert(){
		
		
		if(_gui.listmodel.size() > 0){
			List<String> oldList_names = new ArrayList<String>();
			
			for (int i = 0; i<_gui.listmodel.getSize(); i++){
			
				oldList_names.add(_gui.listmodel2.getElementAt(i).toString());
			
			}
		
			neuer_name = _logik.getNewNames_tv(_gui.textField_prefix.getText(), _gui.textField_staffel.getText(), oldList_names, _gui.chckbx2.isSelected(), _gui.chckbx3.isSelected(), _gui.chckbx4.isSelected(), _gui.chckbx5.isSelected());
			_gui.updateList_new(neuer_name);
			_gui.list2.setSelectedIndex(_gui.list.getSelectedIndex());
			
		}
	}
	
}//end class
