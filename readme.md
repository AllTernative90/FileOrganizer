File Organizer 0.5 Beta
========
A small program for organizing and renaming files in various cases.

What Can It Do?
----------------------------
1. Move files out of subfolders of a directory to it's root.
2. Rename TV-show-files to a standardized format ("ShowName - s00e00.extension")
3. Remove everything after an opening bracket in the filename - starting with '('

As this project started as a pure renamer for tv-shows, this feature is currently the most developed. 
I plan on adding more renaming features in the future.

More Documentation
------------------
Start off with typing in a path to the folder with the files you want to rename / move (path browsing dialogue to be added in future updates)
Hit the button: `Open`
The list on the left will now display all files in this directory.
You are now free to choose to move files from all subfolders to your specified directory (button: `Move Files`)
Using the tabs `TV Show` and `Brackets` will display further options for renaming as well as updating the list of the new filenames on the right.
Using the button `Rename` will rename the files in the left list to the according ones on the right.
`Undo Last Rename` will revert the recent changes.

Known Problems
---------------
The way of renaming the files can result in an error on some systems.
For example is it not possible to rename files in Windows when the directory is the root of the windows installation, in most cases C:.
There might be problems renaming files on other operating systems, too. I wasn't able to check for that, though.

