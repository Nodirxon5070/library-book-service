package com.company.bookservice.constants;


public class Constants {

    public static final String EXAMPLE_BOOK_SUCCESS = """
            {
                 "success":"true",
                 "code":"0",
                 "message":"OK",
                 "data": {
                    "loadId": "Value ...",
                    "customerId": "Value ...",
                    "amount": "Value ...",
                    "status": "Value ..."
                 }
            }
            """;


    public static final String EXAMPLE_BOOK_NOT_FOUND = """
            {
                 "success":"false",
                 "code":"-1",
                 "message":"Borrower with  :: id is not found"
            }
            """;

    public static final String EXAMPLE_AUTHOR_SUCCESS = """
            {
                 "success":"true",
                 "code":"0",
                 "message":"OK",
                 "data": {
                    "loadId": "Value ...",
                    "customerId": "Value ...",
                    "amount": "Value ...",
                    "status": "Value ..."
                 }
            }
            """;


    public static final String EXAMPLE_AUTHOR_NOT_FOUND = """
            {
                 "success":"false",
                 "code":"-1",
                 "message":"Borrower with  :: id is not found"
            }
            """;


}


