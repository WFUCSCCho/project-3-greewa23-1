# Project 3 @ CSC 201 Fall 2024: Sorting Algorithms

## Pledged Work Policy

This is a ___Pledged Work___ assignment.  This means that the work you submit for grading ___must___ be your work product.  
You may not submit the work of others outside of your team, or the modification of work of others outside of your team.
You are encouraged to talk with each other about general problems.  For example, you may talk to someone about "What does 
it mean when the compiler says there is a semicolon missing on line 20", or "I can not get my assignment template to 
download from GitHub, what did you do?".  However, you may not engage in "Could you send me a copy of your work so I can 
see how to get started?".  You may get full and detailed assistance from me, the Teaching Assistant (TA), and the TAs in 
the Computer Science Center.  If you have any question about the appropriateness of assistance, do not hesitate to 
consult with me.

If I believe you have violated our ___Pledge Work___ agreement, I will pursue this matter through the college Honor Council.

## Overview

Sorting algorithms are fundamental techniques in computer science that organize data in a specific order, optimized for 
data handling, retrieval, and analyses. Key algorithms, including Bubble Sort, Merge Sort, Quick Sort, Heap Sort, and 
Odd-Even Transposition Sort, each employ different strategies with varied efficiency in terms of space and time 
often evaluated with Big-O notation. 

In this project, you will: 

1. Implement the Bubble Sort, Merge Sort, Quick Sort, Heap Sort, and Odd-Even Transposition Sort algorithms.
2. Perform the sorting algorithms using already-sorted, shuffled, and reversed datasets lists as input.
3. Time the sorting algorithm performance for the different set of inputs.
4. Graph and analyze the performance of the sorting algorithms.

## Invocation and I/O Files:

The name of the program is `Proj3` ( provided with a `main` method in`Proj2.java` ).

You are encouraged to run and debug code in __IntelliJ IDEA__. Also, the program can be invoked from the command-line as:

```shell
java Proj3 {dataset-file} {sorting-algorithm-type} {number-of-lines}
```
## 1. **Implement Sorting Algorithms**

I have enclosed one starter code:
1. `Proj3.java` 
2. There are no other starter code files, but you can add more classes as needed (e.g., your dataset class). 

The `Proj3.java` file contains the main class that reads the input file and calls the sorting algorithms, as well as 
several unfinished sorting algorithm methods and helper methods that you will need to implement where it is indicated 
(Search for `// FINISH ME`).

The program takes in three command line arguments: 1) the filename if your dataset, 2) the sorting algorithm type to be 
executed (bubble, merge, quick, heap, transposition) and 3) the number of lines of your dataset to read.

For the Bubble Sort and Odd-Even Transposition Sort Algorithms, the return value is an integer corresponding to the 
number of comparisons made during the sorting processes. For the Odd-Even Transposition Sort Algorithm, all comparisons that 
could be made in parallel are counted as a single comparison.

The following is a pseudocode for the Odd-Even Transposition Sort Algorithm:

```
    while !isSorted
        begin 
            isSorted=true
            A loop to perform Bubble sort on odd indexed element
            A loop to perform Bubble sort on even indexed element
        end 
```

## 2. **Perform Sorting Algorithms on Already-Sorted, Shuffled, and Reversed Lists**

You will read your dataset and store the data in an ArrayList. To sort and randomize your ArrayList, you will use the 
`Collections.sort()`, `Collections.shuffle()`, and `Collections.sort(al, Collections.reverseOrder())` commands, 
respectively.

## 3. **Time Sorting Algorithm Performance**

For the Bubble Sort, Merge Sort, Quick Sort, and Heap Sort algorithms, you will use `System.nanoTime()` to calculate 
the time it takes to run them on already-sorted, shuffled, and reversed lists. 

For the Bubble Sort and Odd-Even Transposition Sort algorithms, you will count the number of comparisons made during 
the sorting processes.

Your program will print out the number of lines evaluated and the times and/or comparisons to sort the already-sorted, 
shuffled, and reversed lists to the screen in a human-readable format (i.e., nice to look at) and also separately to a 
file named `analysis.txt` in CSV format. Each time the program runs, it will append the timing results to 
`analysis.txt`. 

In addition, your program will print out the sorted lists to a file named `sorted.txt`. Each time the program runs, it 
will overwrite the previous sorted lists in `sorted.txt`.

## 4. **Graph and Analyze the Performance of the Sorting Algorithms**

Run your program several times for different number of lines of your dataset, N, by choosing different values of the 
second command line argument. After several runs, your `analysis.txt` file will be filled with timing and comparison data.

Using your favorite graphing software (e.g., MS Excel or Google Sheets), plot the running time (in seconds) or number of 
vs. N for each case. Take a screenshot of your graph and put them here by modifying this file, committing, and pushing 
it to this repository.

Bubble Sort, Merge Sort, Quick Sort, and Heap Sort running time (already sorted):
![image](https://github.com/user-attachments/assets/c57bf727-5a6d-42cd-852f-e121ca1e129f)
Merge Sort appears to be O(logN) but there is a lot of fluctuation with these data points. Sorted heap sort appears to be O(logN) but has some fluctuation. Sorted Bubble Sort has O(n) running time. Sorted Quick Sort has a runtime of O(logN). BubbleSort has the smallest time, Heap Sort has the second smallest, Quick Sort has the third, and Merge Sort has the largest time. If I had more data points my conclusions could be more accurate.

Bubble Sort, Merge Sort, Quick Sort, and Heap Sort running time (shuffled):
![image](https://github.com/user-attachments/assets/36f4e087-9550-4cb6-99f3-d7f79da309cf)
Merge Sort, Quick Sort, and Heap Sort have runtimes of O(logN). Bubble Sort has a runtime of O(n^2). Bubble Sort has the largest runtime while Heap Sort has the smallest. There are a lot of fluctuations with the data so my conclusions may not all be accurate.

Bubble Sort, Merge Sort, Quick Sort, and Heap Sort running time (reversed):
![image](https://github.com/user-attachments/assets/60f1eeab-07b9-4ff0-8570-4a187f392c54)
BubbleSort has an O(n) runtime. Merge Sort, Quick Sort, and Heap Sort have a O(logn) runtime. Bubble Sort has the largest runtime while Heap Sort has the smallest. There are some fluctuations with the data.

Bubble Sort and Odd-Even Transposition Sort comparison (already sorted):
![image](https://github.com/user-attachments/assets/3da643da-6613-4adc-8eb5-f83780e5705b)
Bubble Sort has a runtime of O(n). Odd-Even Transposition Sort has a constant runtime. So, Bubble Sort has a larger runtime.

Bubble Sort and Odd-Even Transposition Sort comparison (shuffled):
![image](https://github.com/user-attachments/assets/c7c19bc7-03a5-46cb-9a07-07d58f4958cf)
Bubble Sort has a runtime of O(n^2) and Odd-Even Transposition Sort has a runtime of O(n^2) as well. Bubble Sort has a larger runtime though.

Bubble Sort and Odd-Even Transposition Sort comparison (reversed):
![image](https://github.com/user-attachments/assets/a016fb5e-5562-407b-b7db-1c95463f6052)
Bubble Sort has a runtime of O(n^2) and Odd-Even Transposition Sort has a runtime of O(n^2) as well. Bubble Sort has a larger runtime.

My graph may not illustrate this perfectly and with more data, it would be more accurate.

## Submission:

Your project will be developed and graded via GitHub. Your final "push" is your final submission, and it must occur 
before it is due. On Canvas, enter the url to your Github repository. Your project will not be graded without it.

## Recommendations:

I ___strongly suggest___ that you carefully think through your strategy before just jumping into the code.  Once that 
is working, start adding in new features individually.  A good place to start is building your class.

*In order to get full points of Commenting and Code Style, you need to add comments to every method and head comments 
for each file (providing file description, author, date, and acknowledgement).

```
/∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗*
∗ @file: filename.java
∗ @description: This program implements . . .
∗ @author: Your Name
∗ @date: November 14, 2024
∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗/
```
