package asm02;

import asm02.io.FileService;
import asm02.io.FileServiceImpl;
import asm02.io.InputService;
import asm02.io.InputServiceImpl;
import asm02.sort.Sorting;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static final Scanner SCANNER = new Scanner(System.in);
    public static final String FILE_REPOSITORY = "src/main/java/asm02/file/";

    static FileService fileService = FileServiceImpl.getInstance();
    static InputService inputService = new InputServiceImpl();
    static final Scanner scanner = new Scanner(System.in);

    static double[] values;

    public static void main(String[] args) throws IOException {

        while (true) {
            display();
            System.out.println("Run: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    manualInput();
                    break;
                case 2:
                    values = fileInput();
                    break;
                case 3:
                    bublesort();
                    break;
                case 4:
                    selectionSort();
                    break;
                case 5:
                    insertionSort();
                case 6:
                    searchGreaterValues();
                case 7:
                    searchEqualValue();
                case 0:
                    break;
                default:
                    System.out.println("Please enter a valid option");

            }

        }

//
//        double[] list = readFile("INPUT.TXT");
//
//        List<List<Double>> lists = Sorting.bubleSort(list);
//        for (List<Double> list1 : lists) {
//            fileService.writeToFile(FILE_REPOSITORY.concat("INPUT2.TXT"), Arrays.toString(list1.toArray()) + "\n");
//
//        }

    }

    private static void searchEqualValue() {
        System.out.print("Please enter the value to search: ");
        int search = scanner.nextInt();
        for (int i = 0; i < values.length; i++) {
            if (values[i] == search) {
                System.out.println("The right position: " + i);
            }

        }
    }

    private static void searchGreaterValues() {
        System.out.print("Please enter the value to search: ");
        int search = scanner.nextInt();
        Sorting.selectionSort(values);
        searchLargerValues(values, search);
    }

    private static void insertionSort() {
        Sorting.insertionSort(values);
    }

    private static void selectionSort() {
        Sorting.selectionSort(values);
    }

    private static void bublesort() {
        Sorting.bubleSort(values);
    }

    private static double[] fileInput() {
        System.out.print("Please enter the file path: ");
        String fileName = scanner.next();
        return readFile(FILE_REPOSITORY.concat(fileName));
    }

    private static void manualInput() {
        var input = getDoubles(inputService);
        StringBuilder sb = new StringBuilder();
        for (var x : input) {
            sb.append(x).append(" ");
        }
        try {
            Files.write(Path.of(FILE_REPOSITORY.concat("INPUT.TXT")), sb.toString().getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Cannot write");
        }

    }

    private static void searchLargerValues(double[] list, int search) {
        List<Integer> foundIndices = Sorting.linearSearch(list, search);
        if (!foundIndices.isEmpty()) {
            System.out.print("Larger position(s): ");
            for (int i = 0; i < foundIndices.size(); i++) {
                System.out.print(foundIndices.get(i) + " ");
            }
        } else {
            System.out.println("The value does not exist");
        }
    }


//    private static double[] readFile(String fileName) {
//        Scanner fileScanner;
//        List<Double> list = new ArrayList<Double>();
//        Path file = (Path.of(FILE_REPOSITORY.concat(fileName)));
//        try (BufferedReader bufferedReader = Files.newBufferedReader(file)) {
//            String line = bufferedReader.readLine();
//            String[] numbers = line.split(", ");
//            for (String next : numbers) {
//                if (next.matches("-?\\d+(\\.\\d+)?")) {
//                    System.out.print(next + " ");
//                    list.add(Double.parseDouble(next));
//                }
//
//            }
//            return list.stream().mapToDouble(Double::valueOf).toArray();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        private static double[] getDoubles (InputService inputService){
            return inputService.input();
        }


        private static void writeToFile (FileService fileService, String content){
            System.out.println("Please enter the file path: ...");
            String fileName = SCANNER.nextLine();
            String path = FILE_REPOSITORY.concat(fileName);
        }

        private static void display () {
            System.out.println(DISPLAY_TEXT);
        }

        private static final String DISPLAY_TEXT = """
                +-------------------Menu------------------+

                |      1.Manual Input                     |

                |      2.File input                       |

                |      3.Bubble sort                      |

                |      4.Selection sort                   |

                |      5.Insertion sort                   |

                |      6.Search > value                   |

                |      7.Search = value                   |

                |      0.Exit                             |

                +-----------------------------------------.+""";
    }
