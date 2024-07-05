<!DOCTYPE html>
<html>
  <head>
    <title>Sort Array Website In Java</title>
    <style>
      body {
        font-family: Arial, sans-serif;
        background-color: #f0f8ff;
        margin: 0;
        padding: 0;
        color: #333;
      }
      .container {
        width: 80%;
        margin: 0 auto;
        padding: 20px;
        background-color: #fff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        border-radius: 10px;
        margin-top: 50px;
      }
      .welcome {
        background-color: #0073e6;
        color: #fff;
        text-align: center;
        padding: 20px;
        border-radius: 10px 10px 0 0;
      }
      .form-section {
        margin: 20px 0;
      }
      h2 {
        border-bottom: 2px solid #0073e6;
        padding-bottom: 10px;
      }
      label {
        display: block;
        margin-bottom: 10px;
      }
      input[type="text"] {
        width: 100%;
        padding: 8px;
        margin-bottom: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
      }
      button {
        background-color: #0073e6;
        color: #fff;
        border: none;
        padding: 10px 20px;
        border-radius: 5px;
        cursor: pointer;
      }
      button:hover {
        background-color: #005bb5;
      }
    </style>
  </head>
  <body>
    <div class="welcome">
      <h1>Welcome to Sorting Open Source Project In Java</h1>
    </div>
    <div class="container">
      <div class="form-section">
        <h2>Quick Sorting Array Implementation</h2>
        <form id="sortForm" action="sort" method="post">
          <label for="arrayInput">Enter array values (comma-separated):</label>
          <input type="text" id="arrayInput" name="arrayInput" />
          <button type="submit">Quick Sort</button>
        </form>
      </div>

      <div class="form-section">
        <h2>Heap Sort Array Implementation</h2>
        <form id="heapSortForm" action="heapsort" method="post">
          <label for="arrayInputHeap"
            >Enter array values (comma-separated):</label
          >
          <input type="text" id="arrayInputHeap" name="arrayInput" />
          <button type="submit" name="heapSort">Heap Sort</button>
        </form>
      </div>

      <div class="form-section">
        <h2>Merge Sort Array Implementation</h2>
        <form id="mergeSortForm" action="mergesort" method="post">
          <label for="arrayInputMerge"
            >Enter array values (comma-separated):</label
          >
          <input type="text" id="arrayInputMerge" name="arrayInput" />
          <button type="submit" name="mergeSort">Merge Sort</button>
        </form>
      </div>

      <div class="form-section">
        <h2>Radix Sort Array Implementation</h2>
        <form id="radixSortForm" action="radixsort" method="post">
          <label for="arrayInputRadix"
            >Enter array values (comma-separated):</label
          >
          <input type="text" id="arrayInputRadix" name="arrayInput" />
          <button type="submit" name="radixSort">Radix Sort</button>
        </form>
      </div>

      <div class="form-section">
        <h2>Bucket Sort Array Implementation</h2>
        <form id="bucketSortForm" action="bucketsort" method="post">
          <label for="arrayInputBucket"
            >Enter array values (comma-separated):</label
          >
          <input type="text" id="arrayInputBucket" name="arrayInput" />
          <button type="submit" name="bucketSort">Bucket Sort</button>
        </form>
      </div>
    </div>
  </body>
</html>
