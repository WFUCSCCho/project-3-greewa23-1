/**********************************************************************
 * @file Proj3.java
 * @brief This program implements the Proj2 class which sorts data through
 * the following sorting methods: Quick Sort, Bubble Sort, Merge Sort, Heap
 * Sort, and Odd-Even Transposition Sort. The program outputs the data from
 * each sorting method in a txt file and the sorted list in another.
 * @author Wynne Greene
 * @date: November 14, 2024
 ***********************************************************************/
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileInputStream;
//import java.util.Comparator;
import java.util.Collections;
import java.util.Scanner;

public class Proj3 {
    // Sorting Method declarations
    //Merge Sort sorts the given arraylist with the bounds being the left and right parameters.
    public static <T extends Comparable> void mergeSort(ArrayList<T> a, int left, int right) {
        // Finish Me
        //Sort with lengths >= 2
        if(left + 1<right) {
            //Get the midpoint of the Arraylist
            int mid = (left+right)/2;

            //Sort the first and second halves of the list.
            mergeSort(a, left, mid);
            mergeSort(a, mid, right);
            //Merge the halves after they have been sorted.
            merge(a, left, mid, right);
        }
    }

    //This method is called from mergeSort(). It merges two different arraylists with bounds.
    public static <T extends Comparable> void merge(ArrayList<T> a, int left, int mid, int right) {
        // Finish Me
        //The sizes of the two arrays being merged.

        //Temp arrays:
        //lTemp is the array list that has the values of a from the left index to mid
        //rTemp is the array list that has the values of a from mid to the right index
        ArrayList<T> lTemp = new ArrayList<T>(a.subList(left, mid));
        ArrayList<T> rTemp = new ArrayList<T>(a.subList(mid, right));

        int i = 0, j = 0;

        //Initial index of the merged sub arraylist
        int k = left;
        //Loop while there are still elements in both.
        while (i < lTemp.size() && j < rTemp.size()) {
            //If the element in lTemp is less than or equal to rTemp, set it in a
            //Otherwise, do the vise versa. Increment i and j respectively,
            if (lTemp.get(i).compareTo(rTemp.get(j))<=0){
                a.set(k, lTemp.get(i));
                i++;
            }
            else {
                a.set(k, rTemp.get(j));
                j++;
            }
            k++;
        }
        //Copy all the remaining elements of lTemp into a
        while (i < lTemp.size()) {
            a.set(k, lTemp.get(i));
            i++;
            k++;
        }
        //Copy all the remaining elements of rTemp into a
        while (j < rTemp.size()) {
            a.set(k, rTemp.get(j));
            j++;
            k++;
        }

    }

    //quickSort() is a method that takes an arraylist and sorts it recursively. The method calls
    //itself until the list is sorted.
    public static <T extends Comparable> void quickSort(ArrayList<T> a, int left, int right) {
        // Finish Me
        //Base case, the ArrayList is sorted.
        if (left >= right) {
            return;
        }

        //Partition the data in the a. index is the index of the low
        //partition's last element.
        int index = partition(a, left, right);
        //Recursively sort the low partition and high partition, beginning at index+1.
        quickSort(a, left, index);
        quickSort(a, index + 1, right);
    }

    //partition() performs the partition on a bounded ArrayList. It sorts some of the
    //elements and returns the index for the next partition.
    public static <T extends Comparable> int partition (ArrayList<T> a, int left, int right) {
        // Finish Me

        //Choose the middle element as pivot.
        int center = (left + right-1) / 2;

        //Compare the first, last, and middle elements and order them correctly.
        if(a.get(center).compareTo(a.get(left)) < 0) {
            swap(a, left, center);
        }
        if(a.get(right-1).compareTo(a.get(left)) < 0) {
            swap(a, left, right-1);
        }
        if(a.get(right -1).compareTo(a.get(center)) < 0) {
            swap(a, center, right-1);
        }

        //The median is the pivot so place it at the last index.
        swap(a, center, right-1);

        //Set the pivot.
        T pivot = a.get(right -1);

        //Assign the range to i and j.
        int i = left;
        int j = right-2;

        //Loop while i is less than j.
        while(i<j) {
            //Increment the left index while a.get(i) < pivot
            while(a.get(i).compareTo(pivot) <= 0) {
                i += 1;
            }
            //Decrement right index while pivot < a.get(j).
            while (pivot.compareTo(a.get(j)) <= 0) {
                j -= 1;
            }

            //If zero or one elements remain, then all the numbers are partitioned.
            if(i<j) {
                //Swap elements at i and j with the swap method.
                swap(a, i, j);
            }
            else {
                break;
            }
        }
        //Restore pivot.
        swap(a, i, right-1);
        return i;
    }

    //This performs a swap of two ArrayList elements.
    static <T> void swap(ArrayList<T> a, int i, int j) {
        T temp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, temp);
    }

    //Heap Sort sorts an ArrayList by building a max binary heap and deleting nodes.
    public static <T extends Comparable> void heapSort(ArrayList<T> a, int left, int right) {
        // Finish Me
        //Build a max heap.
        //Index of the last non-leaf node
        int start = (right / 2) - 1;

        for(int i = start; i >= left; i--) {
            //heapify(a, left, right);
            heapify(a, i, right);
        }

        //Swap elements and heapify the max binary heap to get
        //a list in increasing order
        for(int i = right-1; i>=left; i--) {
            //swap max element with the last element
            swap(a, left, i);
            //heapify the heap
            //heapify(a, left, i);
            heapify(a, left, i);
        }
    }

    //heapify() is called by heapSort() to make the binary tree a heap.
    public static <T extends Comparable> void heapify (ArrayList<T> a, int left, int right) {
        // Finish Me
        //Root node
        int maxNode = left;
        int leftChild = (2*left)+1; //Left child of root.
        int rightChild = (2*left)+2; //Right child of root.

        //Compare the leftChild with right and the max node.
        if(leftChild < right && a.get(leftChild).compareTo(a.get(maxNode))>0) {
            maxNode = leftChild;
        }

        //Check if right child is larger than the maxNode and is less than right.
        if(rightChild < right && a.get(rightChild).compareTo(a.get(maxNode))>0) {
            maxNode = rightChild;
        }

        //If the maxNode is not the root, swap and heapify.
        if(maxNode != left) {
            swap(a, left, maxNode);
            //Heapify the subtree with the maxNode as the root.
            heapify(a, maxNode, right);
        }
    }

    //BubbleSort performs bubble sort on the ArrayList. The number of comparisons are counted.
    public static <T extends Comparable> int bubbleSort(ArrayList<T> a, int size) {
        // Finish Me

        int count = 0; //counter for num comparisons
        boolean swapped = true; //flag for swapped
        //End loop when all elements sorted.
        while(swapped) {
            swapped = false; //initialize swap to false
            //Loop through list
            for(int i = 0; i<size - 1; i++) {
                //If current el greater than next el, swap them.
                if(a.get(i).compareTo(a.get(i + 1)) > 0) {
                    swap(a, i, i+1);
                    swapped = true;
                }
                count++; //Increment number of comparisons.
            }
        }
        return count; //return number of comparisons.
    }

    //This method performs Odd-Even Transposition Sort. The number of comparisons are counted.
    public static <T extends Comparable> int transpositionSort(ArrayList<T> a, int size) {
        // Finish Me
        int count = 0; //count is number of comparisons.
        boolean isSorted = false; //Checks if list is sorted.
        //While list is not sorted, continue.
        while(!isSorted) {
            isSorted = true;
            //Increment by 2 to compare only even odd-even pairs.
            for(int i = 0; i<size-1; i+=2) {
                //For the even-odd pair if the current el is greater than the next el
                //swap them.
                if(a.get(i).compareTo(a.get(i + 1)) > 0) {
                    swap(a, i, i+1);
                    isSorted = false;
                }
            }
            count++;

            isSorted = true;
            //Increment by 2 to compare only even even-odd pairs.
            for(int i = 1; i<size-1; i+=2) {
                //for the odd-even pair if the current el is greater than the next el
                //swap them

                if(a.get(i).compareTo(a.get(i + 1)) > 0) {
                    swap(a, i, i+1);
                    isSorted = false;
                }
            }
            count++;
        }
        return count; //Return the total comparisons.
    }

    public static void main(String [] args)  throws IOException {
        //...
        // Finish Me
        //...
        /*The program reads in three command line arguments corresponding to the dataset,
        the type of sorting algorithm to be executed, and the number of lines of data to be
        stored in your ArrayList. If there is more or less than three command line argument, the program
        exits and outputs an error message.*/
        String filename = ""; //The file name.
        String sortAlg = ""; //The sorting algorithm.
        int numLines = 0; //The number of lines to store and sort.
        try {
            //Assign the values.
            filename = args[0];
            sortAlg = args[1];
            numLines = Integer.parseInt(args[2]);
        } catch (Exception e) {
            System.err.println("Invalid number of command line arguments");
            System.exit(1);
        }

        ArrayList<Volcano> origList = new ArrayList<Volcano>();   // original list
        ArrayList<Volcano> quickList = new ArrayList<Volcano>();   // list to be sorted via quick sort
        ArrayList<Volcano> bubbleList = new ArrayList<Volcano>();   // list to be sorted via bubble sort
        ArrayList<Volcano> transpositionList = new ArrayList<Volcano>();   // list to be sorted via transposition sort
        ArrayList<Volcano> heapList = new ArrayList<Volcano>();   // list to be sorted via heap sort
        ArrayList<Volcano> mergeList = new ArrayList<Volcano>();   // list to be sorted via merge sort

        //The file is opened for reading. A Scanner object is created for reading.
        FileInputStream inputFileNameStream = null;
        Scanner inputFileNameScanner = null;

        //The try block attempts to open the file for reading. The catch block is for a file error.
        //An error will be printed to the user.
        try {
            //Open the input file.
            inputFileNameStream = new FileInputStream(filename);
            inputFileNameScanner = new Scanner(inputFileNameStream);

            //The first line is ignored.
            inputFileNameScanner.nextLine();

            //Data is stored in the Volcano Arraylist. We iterate over each line of the file.
            int count = 0; //count keeps track of the line count.
            //Traverse numLines.
            while (count < numLines) {//inputFileNameScanner.hasNext()) {
                //Scan in the line.
                String line = inputFileNameScanner.nextLine();
                String[] parts = line.split(","); // split the string into multiple parts

                Volcano v; //Store the data in v.
                //Condition for exceptions
                if (parts.length != 11) {
                    //data stores the values of each variable.
                    ArrayList<String> data = new ArrayList<>();
                    //s is updated with entries that need to be combined.
                    String s = "";
                    for (int i = 0; i < parts.length; i++) {
                        if (parts[i].indexOf("\"") != -1) {
                            s += parts[i];
                            i++;
                            //Loop until the last quote is found.
                            while (i < parts.length) {
                                s += "," + parts[i];
                                if (parts[i].indexOf("\"") != -1) {
                                    break;
                                }
                                i++;
                            }
                            data.add(s);
                        } else {
                            data.add(parts[i]);
                        }
                    }
                    //Update v with the data.
                    v = new Volcano(data.get(0), data.get(1), data.get(2), data.get(3), data.get(4),
                            Double.parseDouble(data.get(5)), Double.parseDouble(data.get(6)), Integer.parseInt(data.get(7)), data.get(8), data.get(9), data.get(10));
                } else {
                    //Update v with the data from the array.
                    v = new Volcano(parts[0], parts[1], parts[2], parts[3], parts[4],
                            Double.parseDouble(parts[5]), Double.parseDouble(parts[6]), Integer.parseInt(parts[7]), parts[8], parts[9], parts[10]);
                }
                origList.add(v); // add the data onto the ArrayList
                count++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        //This block guarantees the file is closed.
        finally {
            if (inputFileNameStream != null) {
                //The input file is closed.
                inputFileNameStream.close();
            }
        }
        // Fill lists.
        for (int i = 0; i < origList.size(); i++) {
            quickList.add(origList.get(i));
            bubbleList.add(origList.get(i));
            transpositionList.add(origList.get(i));
            heapList.add(origList.get(i));
            mergeList.add(origList.get(i));
        }

        //Create File Writers to open the output files.
        FileWriter out = null;
        FileWriter out2 = null;
        try {
            //Create or open the files to write to it.
            out = new FileWriter("analysis.txt", true);
            out2 = new FileWriter("sorted.txt");

            //To determine execution time, declare start and time.
            long start;
            long time;

            //Check for which sorting algorithm to perform. Call the appropriate method with the correct range.
            //Output the execution time and/or number of comparisons.
            if (sortAlg.equals("quick")) {
                Collections.sort(quickList); //Changed between shuffled, sorted, and reversed to see runtimes of the data.
                //Find the time by calculating the difference between start and time.
                start = System.nanoTime();
                quickSort(quickList, 0, numLines); //Sort the list
                time = System.nanoTime();
                //Print out the data and write to the two output files.
                System.out.println("Quick Sort: Number of Lines=" + numLines + ", Time(ns)=" + (time - start));
                out.write("Quick Sort," + numLines + "," + (time - start) + ",\n");
                out2.write(quickList.toString()); //Output the sorted ArrayList to the file.
            } else if (sortAlg.equals("bubble")) {
                Collections.sort(bubbleList);
                //Find the time by calculating the difference between start and time.
                start = System.nanoTime();
                int bubbleCount = bubbleSort(bubbleList, numLines);
                time = System.nanoTime();
                //Print out the data and write to the two output files.
                System.out.println("Bubble Sort: Number of Lines=" + numLines + ", Time(ns)=" + (time - start) + ", Number of Comparisons=" + bubbleCount);
                out.write("Bubble Sort," + numLines + "," + (time - start) + "," + bubbleCount + "\n");
                out2.write(bubbleList.toString());
            } else if (sortAlg.equals("transposition")) {
                Collections.sort(transpositionList);
                int transpositionCount = transpositionSort(transpositionList, numLines);
                //Print out the data and write to the two output files.
                System.out.println("Transposition Sort: Number of Lines=" + numLines + ", Number of Comparisons=" + transpositionCount);
                out.write("Transposition Sort," + numLines + ",," + transpositionCount + "\n");
                out2.write(transpositionList.toString());
            } else if (sortAlg.equals("heap")) {
                Collections.sort(heapList);
                //Find the time by calculating the difference between start and time.
                start = System.nanoTime();
                heapSort(heapList, 0, numLines);
                time = System.nanoTime();
                //Print out the data and write to the two output files.
                System.out.println("Heap Sort: Number of Lines=" + numLines + ", Time(ns)=" + (time - start));
                out.write("Heap Sort," + numLines + "," + (time - start) + ",\n");
                out2.write(heapList.toString());
            } else if (sortAlg.equals("merge")) {
                Collections.sort(mergeList);
                //Find the time by calculating the difference between start and time.
                start = System.nanoTime();
                mergeSort(mergeList, 0, numLines);
                time = System.nanoTime();
                //Print out the data and write to the two output files.
                System.out.println("Merge Sort: Number of Lines=" + numLines + ", Time(ns)=" + (time - start));
                out.write("Merge Sort," + numLines + "," + (time - start) + ",\n");
                out2.write(mergeList.toString());
            } else {
                System.err.println("Invalid sorting algorithm");
                System.exit(1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        } finally {
            out.close();
            out2.close();
        }
    }
}
