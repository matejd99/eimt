import "./App.css";
import Header from "./components/header/Header";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import ListCountries from "./components/countries/ListCountries";
import CreateCountry from "./components/countries/CreateCountry";
import ListBooks from "./components/books/ListBooks";
import ListAuthors from "./components/authors/ListAuthors";
import { Component } from "react";
import LibraryService from "./services/libraryService";
import CreateAuthor from "./components/authors/CreateAuthor";
import CreateBook from "./components/books/CreateBook";

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      books: [],
      countries: [],
      authors: [],
    };
  }

  render() {
    return (
      <BrowserRouter>
        <div className="App">
          <Header />
          <Routes>
            <Route
              path={"/"}
              exact
              element={<ListBooks books={this.state.books} />}
            />
            <Route
              path={"/create"}
              exact
              element={
                <CreateBook
                  authors={this.state.authors}
                  onSubmit={this.createBook}
                />
              }
            />
            <Route
              path={"/countries"}
              exact
              element={<ListCountries countries={this.state.countries} />}
            />
            <Route
              path={"/countries/create"}
              exact
              element={<CreateCountry onSubmit={this.createCountry} />}
            />
            <Route
              path={"/authors"}
              exact
              element={<ListAuthors authors={this.state.authors} />}
            />
            <Route
              path={"/authors/create"}
              exact
              element={
                <CreateAuthor
                  countries={this.state.countries}
                  onSubmit={this.createAuthor}
                />
              }
            />
          </Routes>
        </div>
      </BrowserRouter>
    );
  }

  componentDidMount() {
    this.fetchCountries();
    this.fetchAuthors();
    this.fetchBooks();
  }

  fetchCountries = () => {
    LibraryService.listCountries().then((res) =>
      this.setState({ countries: res.data })
    );
  };

  createCountry = (name, continent) => {
    return LibraryService.createCountry(name, continent).then((c) => {
      this.setState({ countries: [...this.state.countries, c.data] });
    });
  };

  fetchAuthors = () => {
    LibraryService.listAuthors().then((res) =>
      this.setState({ authors: res.data })
    );
  };

  createAuthor = (name, surname, country) => {
    return LibraryService.createAuthor(name, surname, country).then((c) => {
      this.setState({ authors: [...this.state.authors, c.data] });
    });
  };

  fetchBooks = () => {
    LibraryService.listBooks().then((res) =>
      this.setState({ books: res.data })
    );
  };

  createBook = (name, category, availableCopies, author) => {
    return LibraryService.createBook(
      name,
      category,
      availableCopies,
      author
    ).then((c) => {
      this.setState({ books: [...this.state.books, c.data] });
    });
  };
}

export default App;
