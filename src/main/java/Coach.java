import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Coach {
    private String firstName;
    private String lastName;

    private String Gender;
    private String Contact;
    public Coach(String FirstName,String SecondName,String Contact,String Gender) {
        if (FirstName.isBlank() || SecondName.isBlank() || Contact.isBlank() || Gender.isBlank()) {
            throw new IllegalArgumentException("All fields are required.");
        }
        this.firstName=FirstName;
        this.lastName=SecondName;
        this.Contact=Contact;
        validateGender(Gender);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLastContact() {
        return Contact;
    }

    public String getLastGender() {
        return Gender;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.Gender = gender;
    }

    public void validateGender(String gender) {
        if (!gender.equalsIgnoreCase("male") && !gender.equalsIgnoreCase("female")) {
            throw new IllegalArgumentException("Gender must be either 'male' or 'female'.");
        }
        this.Gender = gender;
    }



    public static void ByCoachName() {

        String filePath = "Timetable.csv";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the Coach name(Hellen James,Lucas Kevin,Janet James,Elizabeth Lee): ");
        String specifiedCoach=scanner.nextLine();
        boolean coachFound=false;


        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            boolean headerSkipped = false;

            while ((line = reader.readLine()) != null) {
                if (!headerSkipped) {
                    // Skip the header line
                    headerSkipped = true;
                    continue;
                }

                String[] tokens = line.split(",");
                if (tokens.length < 5) {

                    continue;
                }

                String day = tokens[0];
                String time = tokens[1];
                String coach = tokens[2];
                String Grade=tokens[6];
                String AvailableCapacity=tokens[5];
                String LessonId=tokens[7];
                int grade=Integer.parseInt(Grade);

                if (coach.equalsIgnoreCase(specifiedCoach)) {
                    coachFound=true;
                    System.out.println("Day: " + day + ", Time: " + time+", Grade Level: "+Grade+", Available capacity: "+AvailableCapacity+", Lesson Id: "+LessonId);
                }
            }

            Learner.bookLesson();

            reader.close();
            if(!coachFound){
                System.out.println("Coach not found");
            }
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        }
    }


    public static void ByDay() {
        // Replace with the actual path to your CSV file
        String filePath = "Timetable.csv";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Day: ");
        String specifiedDay=scanner.nextLine();


        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            boolean headerSkipped = false;

            while ((line = reader.readLine()) != null) {
                if (!headerSkipped) {
                    // Skip the header line
                    headerSkipped = true;
                    continue;
                }

                String[] tokens = line.split(",");
                if (tokens.length < 5) {

                    continue;
                }

                String day = tokens[0];
                String time = tokens[1];
                String coach = tokens[2];
                String Grade=tokens[6];
                String AvailableCapacity=tokens[5];
                String LessonId=tokens[7];

                if (day.equalsIgnoreCase(specifiedDay)) {
                    System.out.println("Coach: " + coach + ", Time: " + time+",Grade Level: "+Grade+", Available capacity: "+AvailableCapacity+", Lesson Id: "+LessonId);
                }
            }
            Learner.bookLesson();

            reader.close();
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        }
    }

    public static void ByGrade() {
        String filePath = "Timetable.csv";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Grade Level (1-5): ");
        String specifiedGrade=scanner.nextLine();


        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            boolean headerSkipped = false;

            while ((line = reader.readLine()) != null) {
                if (!headerSkipped) {
                    // Skip the header line
                    headerSkipped = true;
                    continue;
                }

                String[] tokens = line.split(",");
                if (tokens.length < 5) {

                    continue;
                }

                String day = tokens[0];
                String time = tokens[1];
                String coach = tokens[2];
                String Grade=tokens[6];
                String AvailableCapacity=tokens[5];
                String LessonId=tokens[7];


                if (Grade.equalsIgnoreCase(specifiedGrade)) {
                    System.out.println("day: "+day+", Coach: " + coach + ", Time: " + time+ ", Available Capacity: "+AvailableCapacity+", Lesson Id: "+LessonId);

                }

            }
            Learner.bookLesson();

            reader.close();
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        }
    }

    public static void CoachMonthlyReport() {
        Scanner scanner = new Scanner(System.in);
        String filePath = "Timetable.csv";
        System.out.print("Enter the month i.e march: ");
        String Month= scanner.nextLine();
        System.out.println("Monthly report for "+Month+" :");


        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            boolean headerSkipped = false;

            // Map to store list of ratings for each coach
            Map<String, List<Integer>> coachRatings = new HashMap<>();

            while ((line = reader.readLine()) != null) {
                if (!headerSkipped) {
                    // Skip the header line
                    headerSkipped = true;
                    continue;
                }

                String[] tokens = line.split(",");
                if (tokens.length < 4) {
                    continue;
                }

                String coach = tokens[2];
                int rating = Integer.parseInt(tokens[3]);

                // Update list of ratings for the coach
                if (coachRatings.containsKey(coach)) {
                    coachRatings.get(coach).add(rating);
                } else {
                    List<Integer> ratings = new ArrayList<>();
                    ratings.add(rating);
                    coachRatings.put(coach, ratings);
                }
            }

            reader.close();

            // Print individual ratings for each coach
            System.out.println("Coach\tRatings");
            for (String coach : coachRatings.keySet()) {
                System.out.print(coach + "\t");
                List<Integer> ratings = coachRatings.get(coach);
                for (int rating : ratings) {
                    System.out.print(rating + " ,");
                }
                System.out.println();
            }

            // Print the average rating for each coach
            System.out.println("\nCoach\tAverage Rating");
            for (String coach : coachRatings.keySet()) {
                List<Integer> ratings = coachRatings.get(coach);
                int sum = 0;
                for (int rating : ratings) {
                    sum += rating;
                }
                double averageRating = (double) sum / ratings.size();
                System.out.println(coach + "\t" + averageRating);
            }
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        }
    }


}