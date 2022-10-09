const ListBooks = (props) => {
  return (
    <div>
      <ul>
        {props.books.map((b) => {
          return (
            <li key={b.id}>
              <i>
                {b.name} by {b.author.name} {b.author.surname}
              </i>{" "}
              - {b.category} - {b.availableCopies}
            </li>
          );
        })}
      </ul>
      <a href="/create">Create book</a>
    </div>
  );
};

export default ListBooks;
