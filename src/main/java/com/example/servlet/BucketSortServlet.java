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

@WebServlet(name = "BucketSortServlet", urlPatterns = { "/bucketsort" })
public class BucketSortServlet extends HttpServlet {

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
