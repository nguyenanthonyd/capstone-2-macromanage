package com.pluralsight.util;

import com.pluralsight.models.Order;
import com.pluralsight.models.PriceTable;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {

    private final File receiptsFolder = new File("src/main/resources/receipts");

    public File saveReceipt(Order order, PriceTable priceTable) throws IOException {

        // Create receipts folder
        if (!receiptsFolder.exists()) {
            receiptsFolder.mkdirs(); //make directory
        }

        // Format (Assignment Required)
        LocalDateTime now =LocalDateTime.now();
        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        String fileName = timestamp + ".txt";

        File receiptFile = new File(receiptsFolder, fileName);

        // Date Format in receipt
        String displayDate = now.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));

                // Write file with PrintWriter
        try (PrintWriter writer = new PrintWriter(new FileWriter(receiptFile))) {
            writer.print(order.orderSummary(priceTable));
        }

        return receiptFile;

    }
}

