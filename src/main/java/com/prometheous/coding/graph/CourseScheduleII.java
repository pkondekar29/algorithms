package com.prometheous.coding.graph;

import com.prometheous.coding.utils.PrinterUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleII {

    public static void main(String[] args) {
        PrinterUtils.print(new CourseScheduleII().findOrder(2, new int[][]{{0,1}}));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] incomingEdges = new int[numCourses];
        ArrayList<Integer>[] adjList = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++)
            adjList[i] = new ArrayList<>();

        for(int[] edge : prerequisites) {
            incomingEdges[edge[0]]++;
            adjList[edge[1]].add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < incomingEdges.length; i++) {
            if(incomingEdges[i] == 0)
                queue.offer(i);
        }
        int edgeCount = 0;
        int[] order = new int[numCourses];
        int i = 0;
        while(!queue.isEmpty()) {
            int nextCourse = queue.poll();
            order[i] = nextCourse;
            i++;
            for(int to : adjList[nextCourse]) {
                edgeCount++;
                incomingEdges[to]--;
                if(incomingEdges[to] == 0) {
                    queue.offer(to);
                }
            }
        }
        return edgeCount == prerequisites.length ? order : new int[] {};
    }

}
