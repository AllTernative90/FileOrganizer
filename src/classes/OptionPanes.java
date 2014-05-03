package classes;

import javax.swing.JOptionPane;

public class OptionPanes implements IConstants {
	
	GUI _gui = (Driver._gui);
	Logik _logik = (Driver._logik);
	
	
	public int moveFiles(){
		return JOptionPane.showConfirmDialog(_gui.contentPane,
				PANE_MOVE_FILES_DESC, PANE_MOVE_FILES_TITLE, JOptionPane.YES_NO_OPTION);	
	}
	
	
	public int renameFiles(){
		return JOptionPane.showConfirmDialog(_gui.contentPane,
				PANE_RENAME_FILES_DESC, PANE_RENAME_FILES_TITLE, JOptionPane.YES_NO_OPTION);	
		
	}
	
	
	public void renameCount(int success, int failed){
		JOptionPane.showMessageDialog(_gui.contentPane,
				"Renamed files:\n Successful: " + success + "\n Failed: " + failed);	
	}
	
	
	
	public int undoRename(){
		return JOptionPane.showConfirmDialog(_gui.contentPane,
				PANE_UNDO_RENAME_DESC, PANE_UNDO_RENAME_TITLE, JOptionPane.YES_NO_OPTION);	
		
	}
	
	public void renameFailed(){
		JOptionPane.showMessageDialog(_gui.contentPane,
				PANE_RENAME_FAILED);
		
	}

}
