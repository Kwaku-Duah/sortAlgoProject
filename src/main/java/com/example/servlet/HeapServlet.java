package com.example.servlet;

import java.io.IOException;
import java.util.Arrays;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "HeapServlet", urlPatterns = { "/heapsort" })
public class HeapServlet extends HttpServlet {

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

        heapSort(arr);

        req.setAttribute("sortedArray", arr);

        req.getRequestDispatcher("/WEB-INF/jsp/heapSortedArray.jsp").forward(req, resp);
    }

    private void heapSort(int[] arr) {
        int n = arr.length;


        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }


        for (int i = n - 1; i > 0; i--) {

            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;


            heapify(arr, i, 0);
        }
    }

    private void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;


        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }


        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }


        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }
}
