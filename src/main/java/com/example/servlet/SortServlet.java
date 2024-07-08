package com.example.servlet;

import java.io.IOException;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * A servlet that handles HTTP POST requests to sort an array using the quick sort algorithm.
 */
@WebServlet(name = "SortServlet", urlPatterns = {"/sort"})
public class SortServlet extends HttpServlet {

    /**
     * Handles the HTTP POST request. Retrieves an array of integers from the request,
     * sorts it using the quick sort algorithm, and forwards the sorted array to a JSP page.
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

        if (arrayStr != null && !arrayStr.isEmpty()) {

            int[] arr = Arrays.stream(arrayStr.split(","))
                              .mapToInt(Integer::parseInt)
                              .toArray();
            

            quickSort(arr, 0, arr.length - 1);
            

            req.setAttribute("sortedArray", arr);
            

            req.getRequestDispatcher("/WEB-INF/jsp/sortedArray.jsp").forward(req, resp);
        } else {
            resp.getWriter().println("Please enter valid array values.");
        }
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        
        return i + 1;
    }
}
