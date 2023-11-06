package asm02;

import asm02.exception.FileReadException;
import asm02.io.FileService;
import asm02.io.FileServiceImpl;
import asm02.io.InputService;
import asm02.io.InputServiceImpl;
import asm02.sort.Sorting;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static asm02.sort.Sorting.binarySearch;
import static asm02.sort.Sorting.quickSort;

public class Application {

    public static final Scanner SCANNER = new Scanner(System.in);
    public static final String FILE_REPOSITORY = "src/main/java/asm02/file/";

    static FileService fileService = FileServiceImpl.getInstance();
    static InputService inputService = new InputServiceImpl();
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {

        while (true) {
            int option = scanner.nextInt();
            switch (option) {
                case 1: display();
            }

        }








        var input = getDoubles(inputService);

        for (var x : input) {
            Files.write(Path.of(FILE_REPOSITORY.concat("INPUT.TXT")), (x + " ").getBytes(), StandardOpenOption.APPEND);

        }


        //        writeToFile(fileWriterService, Arrays.toString(input));

        double[] list = readFile("INPUT.TXT");

        List<List<Double>> lists = Sorting.bubleSort(list);
        for (List<Double> list1 : lists) {
            fileService.writeToFile(FILE_REPOSITORY.concat("INPUT2.TXT"), Arrays.toString(list1.toArray()) + "\n");

        }
        Sorting.selectionSort(list);
        searchLargerValues(list, 115);


        double[] cloneList = list.clone();
        quickSort(cloneList);
        int i = binarySearch(cloneList, 1115);
        if (i != -1) {
            System.out.println("The right position: " + i);
        } else {
            System.out.println("The value does not exist");
        }


    }

    private static void searchLargerValues(double[] list, int search) {
        List<Integer> foundIndices = Sorting.linearSearch(list.clone(), search);
        if (foundIndices.size() > 0) {
            System.out.print("Larger position(s): ");
            for (int i = 0; i < foundIndices.size(); i++) {
                System.out.print(foundIndices.get(i) + " ");
            }
        } else {
            System.out.println("The value does not exist");
        }
    }

    private static double[] readFile2(String fileName) {
        FileServiceImpl fileService = FileServiceImpl.getInstance();
        Path file = (Path.of(FILE_REPOSITORY.concat(fileName)));
        List<Double> list = new ArrayList<Double>();
        double[] doubles = null;
        try {
            doubles = fileService.readFromFile(fileName);
        } catch (FileReadException e) {
            System.out.println("Cannot read file " + fileName);
        }

        return doubles;
    }

    private static double[] readFile(String fileName) {
        Scanner fileScanner;
        List<Double> list = new ArrayList<Double>();
        Path file = (Path.of(FILE_REPOSITORY.concat(fileName)));
        try {
            fileScanner = new Scanner(file.toFile());

            while (fileScanner.hasNext()) {
                String next = fileScanner.next();
//                if (StringUtils.isAlphanumeric(next)) {
//                    System.out.println(next);
//                } else {continue;}
                if (next.matches("-?\\d+(\\.\\d+)?")) {
                    System.out.print(next + " ");
                    list.add(Double.parseDouble(next));
                }
            }

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        return list.stream().mapToDouble(Double::valueOf).toArray();
    }

    private static double[] getDoubles(InputService inputService) {
        return inputService.input();
    }


    private static void writeToFile(FileService fileService, String content) {
        System.out.println("Please enter the file path: ...");
        String fileName = SCANNER.nextLine();
        String path = FILE_REPOSITORY.concat(fileName);

//        fileWriterService.writeToFile(path, content);

    }

    private static void display() {
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
