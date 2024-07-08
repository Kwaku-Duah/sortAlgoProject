package com.example.servlet;

import java.io.IOException;
import java.util.Arrays;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * A servlet that handles HTTP POST requests to sort an array using the radix sort algorithm.
 */
@WebServlet(name = "RadixSortServlet", urlPatterns = { "/radixsort" })
public class RadixSortServlet extends HttpServlet {

    /**
     * Handles the HTTP POST request. Retrieves an array of integers from the request,
     * sorts it using the radix sort algorithm, and forwards the sorted array to a JSP page.
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

        radixSort(arr);

        req.setAttribute("sortedArray", arr);

        req.getRequestDispatcher("/WEB-INF/jsp/radixSortArray.jsp").forward(req, resp);
    }

    private void radixSort(int[] arr) {
        int max = Arrays.stream(arr).max().orElse(0);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    private void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        Arrays.fill(count, 0);

        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        System.arraycopy(output, 0, arr, 0, n);
    }
}
