package com.prometheous.coding.graph;

import java.util.*;

public class MovieTicketSolver {

    public static void main(String[] args) {
        // Example from the problem description
        int[][] tickets = {
                {1, 2}, {2, 3}, {1, 3}, {3, 4}, {5, 2}, {9, 2}
        };
        int numPeople = tickets.length;

        System.out.println("Input Ticket Pairs: " + Arrays.deepToString(tickets));

        MovieTicketSolver solver = new MovieTicketSolver();
        int[] solution = solver.solve(numPeople, tickets);

        if (solution != null) {
            System.out.println("Solution Found!");
            System.out.println("Final Seat Assignments: " + Arrays.toString(solution));
            System.out.println("\nCancelled tickets can be inferred from the original pairs.");
            for (int i = 0; i < tickets.length; i++) {
                int assignedSeat = solution[i];
                int cancelledSeat = (tickets[i][0] == assignedSeat) ? tickets[i][1] : tickets[i][0];
                System.out.printf("Person %d gets seat %d, cancelling ticket for seat %d.%n", i, assignedSeat, cancelledSeat);
            }
        } else {
            System.out.println("No valid assignment of non-overlapping seats is possible.");
        }
    }

    private Map<Integer, List<int[]>> adj; // Adjacency list: Seat -> List of [Neighbor, PersonIndex]
    private Set<Integer> visited;          // Set of all visited seats across all components
    private Set<Integer> currentPath;      // Used for cycle detection in a single DFS run

    /**
     * Main method to solve the booking problem.
     *
     * @param m The number of people (and ticket pairs).
     * @param tickets An array of pairs, where tickets[i] is the pair for person i.
     * @return An array where result[i] is the assigned seat for person i, or null if no solution exists.
     */
    public int[] solve(int m, int[][] tickets) {
        adj = new HashMap<>();
        visited = new HashSet<>();
        int[] solution = new int[m];
        Arrays.fill(solution, -1);
        for (int i = 0; i < m; i++) {
            int u = tickets[i][0];
            int v = tickets[i][1];
            adj.computeIfAbsent(u, _ -> new ArrayList<>()).add(new int[]{v, i});
            adj.computeIfAbsent(v, _ -> new ArrayList<>()).add(new int[]{u, i});
        }

        // 2. Process each connected component of the graph
        for (int seat : adj.keySet()) {
            if (!visited.contains(seat)) {
                Set<Integer> componentNodes = new HashSet<>();
                Set<Integer> componentEdges = new HashSet<>();

                // Find all nodes and edges in the current component
                findComponent(seat, componentNodes, componentEdges);

                int vCount = componentNodes.size();
                int eCount = componentEdges.size();

                // 3. Analyze the component and solve
                if (eCount > vCount) {
                    return null; // Impossible case: more people than seats in a component
                }

                // Solve the component. If it fails, the whole problem is unsolvable.
                boolean success = solveComponent(seat, -1, solution);
                if (!success) {
                    return null;
                }
            }
        }
        return solution;
    }

    /**
     * Traverses a component to find all its nodes and edges.
     */
    private void findComponent(int startNode, Set<Integer> componentNodes, Set<Integer> componentEdges) {
        if (visited.contains(startNode)) {
            return;
        }
        visited.add(startNode);
        componentNodes.add(startNode);

        for (int[] edge : adj.getOrDefault(startNode, new ArrayList<>())) {
            componentEdges.add(edge[1]); // Add person index
            findComponent(edge[0], componentNodes, componentEdges);
        }
    }

    /**
     * The core recursive solver for a component, using DFS.
     * It assigns seats from the leaves of the traversal up towards the root.
     *
     * @param u The current seat (node).
     * @param parent The seat from which we arrived at u.
     * @param solution The main solution array to be filled.
     * @return true if a valid assignment was found for this subtree, false otherwise.
     */
    private boolean solveComponent(int u, int parent, int[] solution) {
        currentPath = new HashSet<>(); // Reset path for each component solve
        return dfs(u, parent, solution);
    }

    private boolean dfs(int u, int parent, int[] solution) {
        currentPath.add(u); // Add current node to the path for cycle detection

        for (int[] edge : adj.getOrDefault(u, new ArrayList<>())) {
            int v = edge[0];
            int personIndex = edge[1];

            if (v == parent) continue;

            // If we've already assigned a seat for this person, skip.
            // This happens when we traverse the other direction of an already-solved edge.
            if (solution[personIndex] != -1) continue;

            // Cycle detected
            if (currentPath.contains(v)) {
                // Tentatively assign seat 'u' to this person, breaking the cycle.
                solution[personIndex] = u;
                // Continue the DFS from here. If it fails, we'll backtrack.
            } else {
                // Standard DFS traversal
                if (!dfs(v, u, solution)) {
                    return false; // Child subtree failed, so this path is invalid
                }
            }
        }

        // Post-order traversal logic: Decide the seat for the edge connecting u to its parent.
        // Check if seat 'u' was already taken by a descendant in a cycle-closing assignment.
        boolean uIsTaken = false;
        for (int seat : solution) {
            if (seat == u) {
                uIsTaken = true;
                break;
            }
        }

        // Find the edge connecting to the parent
        for (int[] edge : adj.getOrDefault(u, new ArrayList<>())) {
            int v = edge[0];
            int personIndex = edge[1];
            if (v == parent) {
                if (uIsTaken) {
                    // 'u' is taken, so we MUST assign 'v' (the parent) to this person.
                    // We must check if 'v' is available.
                    for (int seat : solution) {
                        if (seat == v) return false; // Conflict! Parent seat is also taken.
                    }
                    solution[personIndex] = v;
                } else {
                    // 'u' is free, so we claim it for this person.
                    solution[personIndex] = u;
                }
            }
        }

        currentPath.remove(u); // Backtrack from path
        return true;
    }
}
