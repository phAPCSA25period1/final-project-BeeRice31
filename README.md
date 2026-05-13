[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=23598044)
# AP Computer Science A – Final Project
## Software & Systems Development Capstone

# FitTrack - Daily Fitness Tracker

## What This Software Does

FitTrack is a console-based Java application that helps users track their daily fitness activity and measure progress toward personal health goals. Each day, the user logs their workouts, meals, and sleep. The app then calculates a daily progress score as a percentage based on how well the user met their goals. After logging for all 7 days, a weekly summary table is displayed, showing scores across all categories for the full week.

## Who It's For

FitTrack is built for anyone who wants a simple, no-frills way to stay accountable to their fitness goals. Instead of a complex app with accounts and syncing, this program gives a straightforward console experience where you enter your data and immediately see how your day scored. It solves the problem of not knowing whether your daily habits actually align with your goals.

## How to Run the Program

1. Make sure you have the **Java JDK** installed (Java 11 or higher recommended)
2. Clone or download this repository
3. Open a terminal and navigate to the `src` folder
4. Compile all files:
5. Run the program:
6. Follow the on-screen prompts to set your goals and log your week

## Technical Overview

### Main Classes

|      Class      |                              Description                                     |
|-----------------|------------------------------------------------------------------------------|
|      `App`      | Main driver class. Runs the console UI and manages the daily logging loop    |
|     `User`      | Stores the user's name, fitness goal description, and numeric daily targets  |
|   `FitnessLog`  | Holds all logged entries for a single day (workouts, meals, sleep)           |
|  `WorkoutEntry` | Represents one workout session with type, duration, sets, and reps           |
|   `MacroEntry`  | Represents one meal with protein, carbs, fat, and a calorie calculator       |
|   `SleepEntry`  | Represents one night of sleep with hours, quality, and date                  |
|   `GoalTracker` | Calculates workout, protein, and sleep scores and returns a daily percentage |
|  `WeeklyTracker`| Stores and displays scores across all 7 days using a 2D array                |

### Key Data Structures

- **ArrayLists** — `FitnessLog` uses three ArrayLists to store `WorkoutEntry`, `MacroEntry`, and `SleepEntry` objects logged each day
- **2D Array** — `WeeklyTracker` uses a `int[7][3]` array where each row is a day (Mon-Sun) and each column is a category (workout, protein, sleep)

### Program Logic

1. User sets their name, fitness goal, protein goal, sleep goal, and workout goal
2. A 7-day loop runs, prompting the user to log workouts, meals, and sleep each day
3. After each day, `GoalTracker` calculates a score for each category and an overall daily score
4. Scores are stored in the `WeeklyTracker` 2D array via `logDay()`
5. After all 7 days, `printWeeklySummary()` displays the full week table with daily and category averages

## Class Diagram

<img width="1334" height="1014" alt="Final Project ClassDiagram drawio" src="https://github.com/user-attachments/assets/4111e249-4fc6-49dd-9135-b14c406c38ed" />

## Known Limitations / Future Improvements

### What Works Well
- Clean console formatting with consistent headers and dividers
- Input validation prevents crashes from bad numeric input
- Weekly summary clearly shows progress across all categories and days

### What I Would Improve With More Time
- **Persistent data** — right now all data is lost when the program closes. A file save system would let users log one day at a time over a real week
- **Date tracking** — the date in `SleepEntry` is currently hardcoded and could be replaced with `LocalDate.now().toString()` to log the real date automatically
- **More detailed goal feedback** — instead of just a percentage, show messages like "You were 30g short of your protein goal" so the user knows exactly what to improve
- **Yes/no input validation** — the loop prompts that ask "yes/no" don't currently re-prompt on invalid input the way numeric fields do
- **Inheritance** — `WorkoutEntry`, `MacroEntry`, and `SleepEntry` could extend a base `Entry` class to reduce repeated structure
