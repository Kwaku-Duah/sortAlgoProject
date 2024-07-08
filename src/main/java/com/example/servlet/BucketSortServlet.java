package com.example.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * A servlet that handles HTTP POST requests to sort an array using bucket sort algorithm.
 */
@WebServlet(name = "BucketSortServlet", urlPatterns = { "/bucketsort" })
public class BucketSortServlet extends HttpServlet {

    /**
     * Handles the HTTP POST request. Retrieves an array of integers from the request,
     * sorts it using the bucket sort algorithm, and it is picked up at the /endpoint.
     * 
     * @param req  the HttpServletRequest object that contains the request the client made to the servlet
     * @param resp the HttpServletResponse object that contains the response the servlet returns to the client
     * @throws ServletException if the request could not be handled
     * @throws IOException      if an input or output error occurs while the servlet is handling the POST request
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String arrayStr = req.getParameter("arrayInput");

        if (arrayStr == null || arrayStr.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().println("Please provide a valid array.");
            return;
        }

        int[] arr = Arrays.stream(arrayStr.split(","))
                          .mapToInt(Integer::parseInt)
                          .toArray();

        bucketSort(arr);

        req.setAttribute("sortedArray", arr);

        req.getRequestDispatcher("/WEB-INF/jsp/bucketSortArray.jsp").forward(req, resp);
    }

    /**
     * Sorts an array of integers using the bucket sort algorithm.
     * 
     * @param arr the array of integers to be sorted
     */
    private void bucketSort(int[] arr) {
        if (arr.length == 0)
            return;

        int max = Arrays.stream(arr).max().orElse(Integer.MAX_VALUE);
        int min = Arrays.stream(arr).min().orElse(Integer.MIN_VALUE);
        int bucketCount = (max - min) / arr.length + 1;
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);

        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        for (int value : arr) {
            int bucketIndex = (value - min) / arr.length;
            buckets.get(bucketIndex).add(value);
        }

        int index = 0;
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
            for (int value : bucket) {
                arr[index++] = value;
            }
        }
    }
}
