<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bookstore</title>
</head>
<body>
    <h1>Bookstore</h1>

    <h2>All Books</h2>
    <button onclick="fetchAllBooks()">Fetch All Books</button>
    <div id="allBooks"></div>

    <h2>Search Books</h2>
    <input type="text" id="searchText" placeholder="Search text">
    <input type="text" id="genres" placeholder="Genres (comma-separated)">
    <button onclick="searchBooks()">Search</button>
    <div id="searchResults"></div>

    <h2>Add Book</h2>
    <input type="text" id="bookTitle" placeholder="Title">
    <input type="text" id="bookAuthor" placeholder="Author">
    <input type="number" id="bookPrice" placeholder="Price">
    <button onclick="addBook()">Add Book</button>

    <h2>Add Collection</h2>
    <textarea id="bookCollection" placeholder='Enter book collection as JSON'></textarea>
    <button onclick="addCollection()">Add Collection</button>

    <script>
        const apiUrl = '/home'; // Base URL for API requests

        // Fetch all books
        async function fetchAllBooks() {
            try {
                const response = await fetch(`${apiUrl}/allBooks`);
                const data = await response.json();
                document.getElementById('allBooks').innerHTML = JSON.stringify(data, null, 2);
            } catch (error) {
                console.error('Error fetching all books:', error);
            }
        }

        // Search for books
        async function searchBooks() {
            const searchText = document.getElementById('searchText').value;
            const genres = document.getElementById('genres').value.split(',').map(g => g.trim());
            try {
                const response = await fetch(`${apiUrl}/booksMatching?searchText=${encodeURIComponent(searchText)}&genres=${encodeURIComponent(genres)}`);
                const data = await response.json();
                document.getElementById('searchResults').innerHTML = JSON.stringify(data, null, 2);
            } catch (error) {
                console.error('Error searching books:', error);
            }
        }

        // Add a book
        async function addBook() {
            const book = {
                title: document.getElementById('bookTitle').value,
                author: document.getElementById('bookAuthor').value,
                price: parseFloat(document.getElementById('bookPrice').value),
            };
            try {
                const response = await fetch(`${apiUrl}/addBook`, {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    body: JSON.stringify(book),
                });
                const data = await response.json();
                alert('Book added: ' + JSON.stringify(data));
            } catch (error) {
                console.error('Error adding book:', error);
            }
        }

        // Add a collection of books
        async function addCollection() {
            try {
                const collection = JSON.parse(document.getElementById('bookCollection').value);
                const response = await fetch(`${apiUrl}/addCollection`, {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    body: JSON.stringify(collection),
                });
                const data = await response.json();
                alert('Collection added: ' + JSON.stringify(data));
            } catch (error) {
                console.error('Error adding collection:', error);
            }
        }
    </script>
</body>
</html>
