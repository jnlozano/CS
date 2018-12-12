Makefile:
Part1A: make part1a
Part1B: make part1b. The method I used in main was just the static caller, EncrypyMT("abc",3);

Conceptual Question:
It will take 4*charTime+overhead.  This is because 2 turtles will draw two letters at the same time, so 2 letters now take the time of one letter, or one charTime. Therefore, the time of 8 letters is considered as one turtle drawing a 4 letter string. This would be 4*charTime. The overhead is then added since it is serial. 

Pointer Questions:
One of the main benefits I saw was that you only needed to save one node, since that node had the next nodes data and so on. This means that if you want to delete a row, you just need to save the data of the start and end. There is no need to loop through all the nodes and re input them into the string builder. Another benefit was that it was simple to traverse through since each node contained another pointer. It was also easy to know the end since the next pointer would be null if it were the end node.  

I would consider making a counter variable that increases everytime the nextNode is the same character. Then I would use this counter to repeat itself. Also, I would make the pointer have a counter that would increase when the .getLetter method returns the same current letter. So my main answer would be something like while(currNode.nextNode.getLetter() != currNode.getLetter(){counter++;


Design Decision:
I used loops because it made more sense to me. By this I mean that I treated it much like traversing through a normal string. Instead of charAt() in a normal string, I used getLetter() and nextNode to continue the loop. The benfit of this technique is how easy it is since for and while loops have been the backbone of cse8a and 8b so far. A consequence is how much you have to repeat the loop and keeping track of the variables and iteration/conditions. The benefit of recursion is its simplicity. Recursion wouldn't require as much lines of code to be writter and would be generally easy to follow if executed correctly. The consquence is executing it correctly. I personally struggle with recursion and would find this technique a bit hard to implement in MSB. The recursion would require a specific condition with the pointers, which I think would be harder than just making a for loop with a nextNode pointer or a while loop that loops while the pointer is not null. 
