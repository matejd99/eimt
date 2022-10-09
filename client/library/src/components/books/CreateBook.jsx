import React from "react";
import { useNavigate } from "react-router-dom";

const categories = [
  "NOVEL",
  "THRILER",
  "HISTORY",
  "FANTASY",
  "BIOGRAPHY",
  "CLASSICS",
  "DRAMA",
];

const CreateBook = (props) => {
  const navigate = useNavigate();
  const [formData, updateFormData] = React.useState({
    name: "",
    category: categories[0],
    availableCopies: "",
    author: props.authors[0],
  });

  const handleChange = (e) => {
    updateFormData({
      ...formData,
      [e.target.name]: e.target.value.trim(),
    });
  };

  const onSubmit = (e) => {
    e.preventDefault();
    const name = formData.name;
    const category = formData.category;
    const availableCopies = formData.availableCopies;
    const author = formData.author;

    props.onSubmit(name, category, availableCopies, author).then(() => {
      navigate("/");
    });
  };

  return (
    <form onSubmit={onSubmit}>
      <div>
        <label>Name</label>
        <input type="text" name="name" onChange={handleChange}></input>
      </div>
      <div>
        <label>Category</label>
        <select name="category" onChange={handleChange}>
          {categories.map((c) => {
            return (
              <option key={c} value={c}>
                {c}
              </option>
            );
          })}
        </select>
      </div>
      <div>
        <label>Available copies</label>
        <input type="number" name="availableCopies" onChange={handleChange}></input>
      </div>
      <div>
        <label>Author</label>
        <select name="author" onChange={handleChange}>
          {props.authors.map((c) => {
            return (
              <option key={c.id} value={c.id}>
                {c.name} {c.surname}
              </option>
            );
          })}
        </select>
      </div>
      <div>
        <input type="submit"></input>
      </div>
    </form>
  );
};

export default CreateBook;
