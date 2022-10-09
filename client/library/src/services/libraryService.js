import axios  from "axios";

const _axios = axios.create({
  baseURL: "http://localhost:8080/api",
});

const LibraryService = {
  // Countries
  listCountries: () => {
    return _axios.get("/countries");
  },

  createCountry: (name, continent) => {
    return _axios.post("/countries", {
      name,
      continent,
    });
  },

  // Authors
  listAuthors: () => {
    return _axios.get("/authors");
  },

  createAuthor: (name, surname, country) => {
    return _axios.post("/authors", { name, surname, country });
  },

  // Books
  listBooks: () => {
    return _axios.get("/books");
  },

  pageBooks: (req) => {},

  getBook: (id) => {
    return _axios.get("/books/" + id);
  },

  createBook: (name, category, availableCopies, author) => {
    return _axios.post("/books", {
      name,
      category,
      availableCopies,
      author,
    });
  },

  updateBook: (id, name, category, availableCopies, author) => {
    return _axios.put("/books/" + id, {
      name,
      category,
      availableCopies,
      author,
    });
  },

  borrowBook: (id) => {},

  deleteBook: (id) => {},
};

export default LibraryService;
