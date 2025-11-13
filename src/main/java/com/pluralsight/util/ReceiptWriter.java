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

    private final File receiptsFolder = new File("receipts");

    public File saveReceipt(Order order, PriceTable priceTable) throws IOException {

        // Create receipts folder
        if (!receiptsFolder.exists()) {
            receiptsFolder.mkdirs(); //make directory
        }

        // Format: 20250318-143255.txt
        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        String fileName = timestamp + ".txt";

        File receiptFile = new File(receiptsFolder, fileName);

        // Write file with PrintWriter (Workbook 4 style)
        try (PrintWriter writer = new PrintWriter(new FileWriter(receiptFile))) {
            writer.print(order.orderSummary(priceTable));
        }

        return receiptFile;
    }
}

