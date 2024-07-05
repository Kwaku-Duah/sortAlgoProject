<!DOCTYPE html>
<html>
<head>
    <title>Radix Sorted Array Results</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f4f4f4;
        }
        h2 {
            color: #333;
        }
        .result-container {
            margin-top: 20px;
            background-color: #f9f9f9;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .back-button {
            margin-top: 20px;
            display: inline-block;
            background-color: #0073e6;
            color: #fff;
            padding: 10px 20px;
            border-radius: 5px;
            text-decoration: none;
            transition: background-color 0.3s ease;
        }
        .back-button:hover {
            background-color: #005bb5;
        }
    </style>
</head>
<body>
    <h2>Radix Sorted Array Results</h2>
    <div class="result-container">
        <% int[] sortedArray = (int[]) request.getAttribute("sortedArray"); %>
        [<% for (int i = 0; i < sortedArray.length; i++) {
                out.print(sortedArray[i]);
                if (i < sortedArray.length - 1) {
                    out.print(", ");
                }
            } %>]
    </div>
    <a class="back-button" href="index.jsp">Back to Algorithms</a>
</body>
</html>
