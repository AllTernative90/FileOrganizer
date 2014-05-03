package classes;

public interface IConstants {
	
	//Zur einfacheren Verwendung der Aufrufe/Referenz von Elementen der GUI werden Konstanten vorgegeben
	
	//Elemente der GUI - Referenziert in Driver.java
	final String BTN_OPEN = "Open"; 
	final String BTN_CHOOSE_DIR = "Choose Directory";
	final String BTN_RENAME = "Rename"; 
	final String BTN_RELOADLIST = "Reload List"; 
	final String BTN_REMOVE_FILE_FROM_LIST = "Remove File From List"; 
	final String BTN_MOVEFILES = "Move Files"; 
	final String BTN_UNDO_LAST_RENAME = "Undo Last Rename"; 
	
	final String CHECKBOX_1 = "sXXeXX (s02e13 -> Name - s02e13)";
	final String CHECKBOX_2 = "01x11 (2x13 / 02x13 -> Name - s02e13)";
	final String CHECKBOX_3 = ".XX. (.13. -> Name - s02e13)";
	final String CHECKBOX_4 = ".XXX. (.213. -> Name - s02e13)";
	final String CHECKBOX_5 = "3 Digits (213 -> Name - s02e13)";
	
	
	//Sonstige Elemente der GUI
	final String PROGRAM_TITLE = "FileOrganizer 0.5 beta"; 
	final String PROGRAM_INFO = ("<html><br>This program is designed to rename files in special use cases.<br>\r\nIt's also possible to move files from the subfolders of a chosen directory to it's parent directory.<br><br>\r\n1. Start off selecting a folder path with the files you want to rename / move.<br>\r\n2. Hit \"Open\".<br>\r\n(3. Move the files from the subdirectories with the button \"Move Files\")<br>\r\n4. Choose a mode<br><br>\r\n\r\n  -TV Show: Rename files to this format: \"Simpsons - s04e13\"<br>\r\n  -Brackets: Remove everything after the last bracket in a filename - starting with '('<br><br>\r\n\r\n5. The files displayed on the left list will be renamed to the according ones on the right.<br>\r\n6. Remove items from the list or rename the displayed files.<br><br>\r\nHover over buttons for a description in the tooltip! </html>");
	final String TAB_ABOUT = "About"; 
	final String TAB_ABOUT_DESC = "General information about the program and how it works."; 
	final String TAB_TVSHOW = "TV Show"; 
	final String TAB_TVSHOW_DESC = "This mode is used for renaming TV Shows."; 
	final String TAB_BRACKETS = "Brackets"; 
	final String TAB_BRACKETS_DESC = "This mode is used for removing everything after the last bracket in a filename, starting with '('."; 
	
	final String LBL_TVSHOW_NAME = "TV Show Name:";
	final String LBL_SEASON = "Season:";
	final String LBL_TVSHOW_CRITERIA = "TV Show Rename Criteria:";
	final String LBL_CURRENT_FILENAMES = "Current Filenames:";
	final String LBL_NEW_FILENAMES = "New Filenames:";
	final String LBL_FOLDERPATH = "Folderpath:";
	final String LBL_FILECOUNT = "*Filecount*";
	final String LBL_FILES_IN_LIST = " Files In List";
	
	final String BTN_OPEN_TOOLTIP = "This button will open the folder path you typed in the textfield above.";
	final String BTN_CHOOSE_DIR_TOOLTIP = "This button will allow you to open a menu to choose the directory instead of typing it in the textfield to the left.";
	final String BTN_MOVEFILES_TOOLTIP = "This button will move all files from all subfolders of the selected directory to this path.";
	final String BTN_RENAME_TOOLTIP = "This button will rename the files from the left to the files to the right list.";
	final String BTN_RELOADLIST_TOOLTIP = "This button will refresh the contents of the list. Useful if you change files in the directory after you opened the path inside this program.";
	final String BTN_REMOVE_FILE_FROM_LIST_TOOLTIP = "This button will remove the selected item from the list for renaming.";
	
	
	//Konstanten der OptionPanes.java
	final String PANE_MOVE_FILES_TITLE = "Move Files?";
	final String PANE_MOVE_FILES_DESC = "Do you want to move all the files from the subdirectories of the specified path to itself?";
	final String PANE_RENAME_FILES_TITLE = "Rename Files?";
	final String PANE_RENAME_FILES_DESC = "Are you sure you want to rename the files displayed in the lists to the names on the right list?";
	final String PANE_UNDO_RENAME_TITLE = "Undo Rename?";
	final String PANE_UNDO_RENAME_DESC = "This will undo the last renaming of files. Are you sure you want to undo that action?";
	final String PANE_RENAME_FAILED = "Renaming failed. Please enter the title of the show.";
}
