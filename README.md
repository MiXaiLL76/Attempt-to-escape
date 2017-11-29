# Attempt to escape

The prisoner tries to escape from the castle, which consists square rooms arranged in the form of a rectangle M × N.
Between any two neighboring rooms there is a door, however some rooms are closed and the prisoner can not be got into them.
In the beginning, the prisoner is in a corner room and for rescue he needs to get into the opposite corner room. 
He does not have much time, only M + N-1, including the starting and ending room on his way, that is, with each transition to the next room, the distance to the exit from the castle should decrease.
You need to find the number of different routes leading to the rescue.

# Input format
The first line of input contains natural numbers M and N not exceeding 1000.
Next comes the castle plan in the form of M lines of N characters in each.
One symbol corresponds to one room: if the symbol is 1, then you can enter the room, if it is 0, then the room is closed.
The initial position of the prisoner is the bottom left corner (the first character of the last line), the output is in the upper right corner (the last character of the first line, both of these symbols are 1).
# Output Format
The program should print the number of routes leading the prisoner to the exit or the word "impossible" if such routes do not exist.

# Example
Input | Output
------------ | -------------
3 5|3
11111
10101
11111

Input | Output
------------ | -------------
3 5|impossible
11101
10101
10111

# The Olympic Challenge