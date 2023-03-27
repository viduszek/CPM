package org.example;

import java.util.*;

public class ProcessGraph {
    private static Scanner scanner = new Scanner(System.in);
    private static int numNodes;
    private static int[] nodeIds;
    private static float[] nodeDurations;
    private static List<Integer>[] prevNodeIdsList; // list of previous node IDs for each node
    private static int[] nextNodeIds;
    private static boolean isOperatingOnNextNodes;

    public static void main(String[] args) {
        // Prompt user for operating mode
        System.out.println("Enter 1 if operating on next nodes, 2 if operating on previous nodes:");
        int mode = scanner.nextInt();
        isOperatingOnNextNodes = (mode == 1);

        // Prompt user for number of nodes
        System.out.println("Enter number of nodes:");
        numNodes = scanner.nextInt();

        // Initialize arrays
        nodeIds = new int[numNodes];
        nodeDurations = new float[numNodes];
        prevNodeIdsList = new ArrayList[numNodes];
        nextNodeIds = new int[numNodes];

        for (int i = 0; i < numNodes; i++) {
            prevNodeIdsList[i] = new ArrayList<Integer>();
        }

        // Prompt user for node information
        for (int i = 0; i < numNodes; i++) {
            System.out.println("Enter node's details: " + i);
            nodeIds[i] = i;

            System.out.println("Enter node duration:");
            nodeDurations[i] = scanner.nextFloat();

            if (isOperatingOnNextNodes) {
                System.out.println("Enter ID of next node (or -1 if none):");
                nextNodeIds[i] = scanner.nextInt();
            } else {
                System.out.println("Enter IDs of previous nodes (separated by commas, or -1 if none):");
                String[] prevNodeIdsStr = scanner.next().split(",");
                for (String prevNodeId : prevNodeIdsStr) {
                    if (!prevNodeId.equals("-1")) {
                        prevNodeIdsList[i].add(Integer.parseInt(prevNodeId.trim()));
                    }
                }
            }
        }

        // Convert list of previous node IDs to array of previous node IDs
        int maxPrevNodes = 0;
        for (List<Integer> prevNodeIds : prevNodeIdsList) {
            if (prevNodeIds.size() > maxPrevNodes) {
                maxPrevNodes = prevNodeIds.size();
            }
        }

        int[][] prevNodeIds = new int[numNodes][maxPrevNodes];
        for (int i = 0; i < numNodes; i++) {
            for (int j = 0; j < prevNodeIdsList[i].size(); j++) {
                prevNodeIds[i][j] = prevNodeIdsList[i].get(j);
            }
        }

        // Print out the graph
        System.out.println("Process graph:");

        for (int i = 0; i < numNodes; i++) {
            System.out.print(nodeIds[i] + " (" + nodeDurations[i] + ")");

            if (isOperatingOnNextNodes) {
                if (nextNodeIds[i] != -1) {
                    System.out.print(" -> " + nodeIds[nextNodeIds[i]]);
                }
            } else {
                System.out.print(" <- ");
                for (int j = 0; j < prevNodeIds[i].length; j++) {
                    if (prevNodeIds[i][j] != 0) {
                        System.out.print(nodeIds[prevNodeIds[i][j]] + " ");
                    }
                }
            }

            System.out.println();
        }
    }
}
