import React from "react";
import { useNavigate } from "react-router-dom";

const CreateAuthor = (props) => {
  const navigate = useNavigate();
  const [formData, updateFormData] = React.useState({
    name: "",
    surname: "",
    country: "",
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
    const surname = formData.surname;
    const country = formData.country;

    props.onSubmit(name, surname, country).then(() => {
      navigate("/authors");
    });
  };

  return (
    <form onSubmit={onSubmit}>
      <div>
        <label>Name</label>
        <input type="text" name="name" onChange={handleChange}></input>
      </div>
      <div>
        <label>Surname</label>
        <input type="text" name="surname" onChange={handleChange}></input>
      </div>
      <div>
        <label>Country</label>
        <select name="country" onChange={handleChange}>
          <option>Blank</option>
          {props.countries.map((c) => {
            return (
              <option key={c.id} value={c.id}>
                {c.name}
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

export default CreateAuthor;
