package com.example.servlet;

import java.io.IOException;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "SortServlet", urlPatterns = {"/sort"})
public class SortServlet extends HttpServlet {

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
