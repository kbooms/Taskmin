# Taskmin
## A lightweight To/Do Terminal Application
This is my personal task list application. I started designing and working on it as a terminal app. I like utilizing the keyboard as much as possible, and keeping the use of my mouse to a minimum.

Why a terminal app?
- I want to be able to rapidly generate task lists with as minimal keystrokes as possible.
- I can save and load simple lists as text files
- The effort of keeping my fingers on the keyboard and using it as a primary navigation tool will help me become a better developer. 
- Less time on the mouse means less chance to get distracted.
- I like terminal apps. It's a fun way for me to practice code.

The code is written in Java. Feel free to download this in your IDE of choice and try it out. Thanks for viewing!

> Code is basically spaghetti right now. Basic functionality is there. But it needs encapsulation and code separation. Also a few bugs I need to fix.

> Eventually I plan to add color and a better UI.

Initial Upload, version 0.5

- Supports adding and removing tasks from a List
- Supports setting a Description for a List of Tasks
- Supports saving a List as .txt
- Supports loading an existing .txt List
- Reads description embedded in .txt file and translates to application


<b> Known Bugs </b>

- Opening a list does not clear a currently opened list
- Returning to the main menu without saving a list, does not clear the list
	+ Creating a new list shows tasks left from the previous list
- Removing a list task that does not exist needs an exception. Throws an error right now