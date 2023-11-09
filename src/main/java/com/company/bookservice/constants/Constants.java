package com.company.bookservice.constants;


public class Constants {

    public static final String EXAMPLE_BOOK_SUCCESS = """
            {
                 "success":"true",
                 "code":"0",
                 "message":"OK",
                 "data": {
                    "bookId": "Value ...",
                    "name": "Value ...",
                    "authorId": "Value ...",
                    "languageId": "Value ...",
                    "imageId": "Value ...",
                    "orderBookId": "Value ..."
                    "publisherId": "Value ..."
                    "price": "Value ..."
                    "page": "Value ..."
                    "amount": "Value ..."
                    "published": "Value ..."
                 }
            }
            """;


    public static final String EXAMPLE_BOOK_NOT_FOUND = """
            {
                 "success":"false",
                 "code":"-1",
                 "message":"Book with  :: id is not found"
            }
            """;

    public static final String EXAMPLE_AUTHOR_SUCCESS = """
            {
                 "success":"true",
                 "code":"0",
                 "message":"OK",
                 "data": {
                    "authorId": "Value ...",
                    "firstName": "Value ...",
                    "lastName": "Value ...",
                    "age": "Value ..."
                    "books": "Value ..."
                    "createdAt": "Value ..."
                    "updatedAt": "Value ..."
                    "deletedAt": "Value ..."
                 }
            }
            """;


    public static final String EXAMPLE_AUTHOR_NOT_FOUND = """
            {
                 "success":"false",
                 "code":"-1",
                 "message":"Author with  :: id is not found"
            }
            """;


}


