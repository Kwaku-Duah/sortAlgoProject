<!DOCTYPE html>
<html>
<head>
    <title>Quick Sorting Array Results...</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        h2 {
            color: #333;
        }
        .result-container {
            margin-top: 20px;
            background-color: #f9f9f9;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
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
    <h2>Sorted Array Results</h2>
    <div class="result-container">
        [<%
            int[] sortedArray = (int[]) request.getAttribute("sortedArray");
            if (sortedArray != null) {
                for (int i = 0; i < sortedArray.length; i++) {
                    if (i > 0) {
                        out.print(", ");
                    }
                    out.print(sortedArray[i]);
                }
            }
        %>]
    </div>
    <a class="back-button" href="index.jsp">Back to Algorithms</a>
</body>
</html>
