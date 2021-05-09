package com.prometheous.coding.graph;

import com.prometheous.coding.utils.PrinterUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleI {

    public static void main(String[] args) {
        PrinterUtils.print(new CourseScheduleI().canFinish(20, new int[][]
                {{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}}));
        PrinterUtils.printLine();
        PrinterUtils.print(new CourseScheduleI().canFinishEff(20, new int[][]
                {{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}}));
    }

    public boolean canFinishEff(int numCourses, int[][] prerequisites) {
        int[] incomingEdges = new int[numCourses];  // Array to keep all the incoming edges for each course
        ArrayList<Integer>[] adjList = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++)
            adjList[i] = new ArrayList<>();

        for (int[] prerequisite : prerequisites) {
            adjList[prerequisite[1]].add(prerequisite[0]);   // Take course i,1 before i,0
            incomingEdges[prerequisite[0]]++;   // Incoming edge for 0th course
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < incomingEdges.length; i++) {
            if(incomingEdges[i] == 0)   // If there are no incoming edge, we can start the top sort from this element
                queue.offer(i);
        }
        int edgeCount = 0;
        while(!queue.isEmpty()) {
            int nextCourse = queue.poll();
            for(int to : adjList[nextCourse]) {
                edgeCount++;
                incomingEdges[to]--;    // Reduce the incoming edge for this course
                if(incomingEdges[to] == 0)  // if the incoming edges become 0, we can start the top sort for it
                    queue.offer(to);
            }
        }
        return edgeCount == prerequisites.length;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] aj = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++)
            aj[i] = new ArrayList<>();

        for (int[] prerequisite : prerequisites)
            aj[prerequisite[1]].add(prerequisite[0]);   // Take course i,1 before i,0

        return !cycleExists(numCourses, aj);
    }

    private boolean cycleExists(int numCourses, ArrayList<Integer>[] aj) {
        boolean[] visited = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++)
            if(dfs(aj, i, visited))
                return true;
        return false;
    }

    private boolean dfs(ArrayList<Integer>[] adjList, int at, boolean[] visited) {
        if(visited[at]) return true;    // If it is visited, cycle exists

        visited[at] = true;
        for(Integer to : adjList[at]) {
            if(dfs(adjList, to, visited))
                return true;
        }
        visited[at] = false;

        return false;
    }
}
