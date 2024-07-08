package com.example.servlet;

import java.io.IOException;
import java.util.Arrays;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * A servlet that handles HTTP POST requests to sort an array using the merge sort algorithm.
 */
@WebServlet(name = "MergeSortServlet", urlPatterns = { "/mergesort" })
public class MergeSortServlet extends HttpServlet {

    /**
     * Handles the HTTP POST request. Retrieves an array of integers from the request,
     * sorts it using the merge sort algorithm, and forwards the sorted array to a JSP page.
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
        
        mergeSort(arr);

        req.setAttribute("sortedArray", arr);

        req.getRequestDispatcher("/WEB-INF/jsp/mergeSortArray.jsp").forward(req, resp);
    }

    private void mergeSort(int[] arr) {
        if (arr.length < 2)
            return;
        
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    private void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < left.length) {
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }
}
