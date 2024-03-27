# Reservations
This Java program is designed to calculate the maximum profit that can be obtained from booking reservations for two rooms. It does so by employing dynamic programming and memoization techniques to efficiently solve the problem.

The program defines a nested class `Reserves` to store the start day, end day, and price of each reservation. The main logic for calculating the maximum profit is encapsulated within the `MaxProfit` method, which takes the current index in the list of reservations, the current availability of each room, the list of all reservations, and a memoization hashmap to avoid recalculating profits for the same states.

The algorithm works as follows:
* If it reaches the end of the reservations list, it returns 0 since there are no more reservations to process.
* It generates a unique key for the current state (index and room availabilities) and checks if this state has already been computed. If so, it returns the stored result to avoid redundant calculations.
* It recursively calls itself to calculate the profit of skipping the current reservation.
* It also iterates through each room to check if the current reservation can be accommodated (based on start and end days). If the reservation fits, it calculates the profit for taking this reservation and updates the room's availability.
* The maximum profit between taking or skipping the current reservation is then calculated and stored in the memoization hashmap.

The `main` method reads input from a file named "in.txt," which contains the reservations data. It initializes a list of `Reserves` objects with this data and sorts them by start day to ensure reservations are processed in chronological order. The program then invokes the MaxProfit method with initial parameters and prints the maximum profit that can be achieved.
