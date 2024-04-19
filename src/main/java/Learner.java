import java.io.*;
import java.util.*;

class Learner {
    private String firstName;
    private String lastName;
    private String grade;
    private int age;
    private String emergencyContact;
    private String gender;
    private int attendedLessons;
    private int cancelledLessons;
    private int bookedLessons;

    public static int BookingId;
    static Scanner scanner = new Scanner(System.in);

    static String LessonStatus="";

    private static final Set<String> VALID_GRADES = new HashSet<>(Arrays.asList("1", "2", "3", "4", "5"));
    public Learner(String firstName, String lastName, String grade, int age, String emergencyContact, String gender) {
        if (firstName.isBlank() || lastName.isBlank() || grade.isBlank() || emergencyContact.isBlank() || gender.isBlank()) {
            throw new IllegalArgumentException("All fields are required.");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        if (validateGrade(grade)) {
            this.grade = grade;
        } else {
            throw new IllegalArgumentException("Invalid grade: " + grade);
        }
        ValidateAge(age);
        this.emergencyContact = emergencyContact;
        validateGender(gender);

    }


    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGrade() {
        return grade;
    }

    public int getAge() {
        return age;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public int getAttendedLessons() {
        return attendedLessons;
    }

    public int getCancelledLessons() {
        return cancelledLessons;
    }

    public int getBookedLessons() {
        return bookedLessons;
    }

    public String getGender() {
        return gender;
    }

    public void ValidateAge(int age) {
        if (age < 4 || age > 11) {
            throw new IllegalArgumentException("Age must be between 4 and 11.");
        }
        this.age = age;
    }

    private boolean validateGrade(String grade) {
        // Check if the grade is in the set of valid grades
        return VALID_GRADES.contains(grade);
    }
    public void validateGender(String gender) {
        if (!gender.equalsIgnoreCase("male") && !gender.equalsIgnoreCase("female")) {
            throw new IllegalArgumentException("Gender must be either 'male' or 'female'.");
        }
        this.gender = gender;
    }




    // Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAttendedLessons(int attendedLessons) {
        this.attendedLessons = attendedLessons;
    }

    public void setCancelledLessons(int cancelledLessons) {
        this.cancelledLessons = cancelledLessons;
    }

    public void setBookedLessons(int bookedLessons) {
        this.bookedLessons = bookedLessons;
    }

    public static void cancel_change_booking(){
        System.out.print("Enter the booking id of the lesson to be changed: ");
        BookingId=scanner.nextInt();
        scanner.nextLine();
        System.out.println("Which action do you want to do?:");
        System.out.println("1.Cancel");
        System.out.println("2.Change Booking");
        String choice=scanner.nextLine();
        switch (choice) {
            case "1":
                System.out.println("Lesson Booking of Id " + BookingId + " cancelled successfully");
                break;
            case "2":
                changeBooking(BookingId);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    public static void changeBooking(int Booking_id) {

        System.out.println("View the timetable By: ");
        System.out.println("1.Day ");
        System.out.println("2.Coach ");
        System.out.println("3.Grade Level ");
        String choice=scanner.nextLine();
        switch (choice){
            case "1":
                Coach.ByDay();
                break;
            case "2":
                Coach.ByCoachName();
                break;
            case "3":
                Coach.ByGrade();
                break;
        }
    }

    public static void RegisterNewLearner() {
        try {

            System.out.print("Enter first name: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter last name: ");
            String lastName = scanner.nextLine();
            System.out.print("Enter grade level (1-5): ");
            String grade = scanner.nextLine();
            System.out.print("Enter age (4-11): ");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter emergency contact: ");
            String emergencyContact = scanner.nextLine();
            System.out.print("Enter gender: ");
            String gender = scanner.nextLine();

            // Validate age and grade
            if (age < 4 || age > 11) {
                System.out.println("Invalid age. Age must be between 4 and 11.");
                return;
            }
            int gradeLevel = Integer.parseInt(grade);
            if (gradeLevel < 0 || gradeLevel > 5) {
                System.out.println("Invalid grade. Grade must be between 0 and 5.");
                return;
            }

            Learner newLearner = new Learner(firstName, lastName, grade, age, emergencyContact, gender);


            try (PrintWriter writer = new PrintWriter(new FileWriter("learners.csv", true))) {
                if (writer.checkError()) {
                    System.out.println("Error writing to file.");
                    return;
                }
                if (writer.checkError()) {
                    System.out.println("Error writing to file.");
                    return;
                }
                writer.println(newLearner.getFirstName() + "," + newLearner.getLastName() + "," + newLearner.getGrade() + ","
                        + newLearner.getAge() + "," + newLearner.getEmergencyContact() + "," + newLearner.getGender() + ","
                );
                System.out.println("New learner " + newLearner.getFirstName() + " " + newLearner.getLastName() + " registered successfully!");
            } catch (IOException e) {
                System.out.println("Error writing to file: " + e.getMessage());
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid numeric values for age and grade.");
        }
    }

    public static void BookALesson() {

        System.out.println("View the timetable By: ");
        System.out.println("1.Day ");
        System.out.println("2.Coach ");
        System.out.println("3.Grade Level ");
        String choice=scanner.nextLine();
        switch (choice){
            case "1":
                Coach.ByDay();
                break;
            case "2":
                Coach.ByCoachName();
                break;
            case "3":
                Coach.ByGrade();
                break;
        }
    }

    public static void attendALesson(){



        int LessonId;
        while (true) {
            System.out.print("Enter the lesson ID (between 1 and 44): ");
            LessonId = scanner.nextInt();

            if (LessonId >= 1 && LessonId <= 44) {
                break;
            } else {
                System.out.println("Invalid lesson ID. Please enter a value between 1 and 44.");
            }
        }


        scanner.nextLine();
        System.out.print("Write a lesson review: ");
        String LessonReview=scanner.nextLine();



        while (true) {
            System.out.print("Enter the lesson  rating (between 1 and 5): ");
            int Rating= scanner.nextInt();

            if (Rating >= 1 && Rating <= 5) {
                break;
            } else {
                System.out.println("Invalid lesson rating. Please enter a value between 1 and 5");
            }
        }
        System.out.println("Lesson with Lesson Id: "+LessonId+", Attended successfully");
        LessonStatus="Attended";
        System.out.println("Lesson status: "+LessonStatus);
    }

    public static void bookLesson(){

        String filePath = "Timetable.csv";
        System.out.print("Enter the lesson id: ");
        String SpecifiedId=scanner.nextLine();

        System.out.print("Your current grade level: ");
        int currentGrade= scanner.nextInt();


        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            boolean headerSkipped = false;

            while ((line = reader.readLine()) != null) {
                if (!headerSkipped) {

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




                if (LessonId.equalsIgnoreCase(SpecifiedId)) {

                    if(AvailableCapacity.equals("0")){
                        System.out.println("Lesson is full");
                    }else{

                        if (currentGrade == grade || currentGrade == grade + 1) {

                            System.out.println("Lesson booked successfully.");
                        } else {
                            System.out.println("Grade " + grade + " learner can only book Grade " + grade + " or Grade " + (grade + 1) + " lessons.");
                            return;
                        }


                        LessonStatus="Booked";
                        BookingId= (int) (Math.random() * 100) + 1;

                        System.out.println("Lesson status: "+LessonStatus);
                        System.out.println("Booking Id: "+BookingId);
                    }

                }
            }

            reader.close();
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        }
    }

    public static void LearnerMonthlyReport() {
        List<Learner> learners = new ArrayList<>();
        String filePath = "learners.csv";



        // Prompt user to input month number
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the month number (e.g., 03 for March): ");
        String month = scanner.nextLine();

        // Parse learner data from the CSV file
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean headerSkipped = false;

            while ((line = reader.readLine()) != null) {
                if (!headerSkipped) {
                    // Skip the header line
                    headerSkipped = true;
                    continue;
                }

                String[] tokens = line.split(",");
                if (tokens.length < 9) {
                    continue;
                }

                Learner learner = new Learner(tokens[0], tokens[1], tokens[2], Integer.parseInt(tokens[3]), tokens[4], tokens[5]);
                learner.setBookedLessons(Integer.parseInt(tokens[8]));
                learner.setCancelledLessons(Integer.parseInt(tokens[7]));
                learner.setAttendedLessons(Integer.parseInt(tokens[6]));

                learners.add(learner);
            }
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        }


        // Print learner report for each week
        for (int week = 1; week <= 4; week++) {
            System.out.println("Week " + week + " of Month " + month);
            for (Learner learner : learners) {
                System.out.println("Learner: " + learner.getFirstName() + " " + learner.getLastName());
                System.out.println("Booked Lessons: " + learner.getBookedLessons());
                System.out.println("Cancelled Lessons: " + learner.getCancelledLessons());
                System.out.println("Attended Lessons: " + learner.getAttendedLessons());
                System.out.println();
            }
        }
    }

}
