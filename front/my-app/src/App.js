import './App.css';
import {
  BrowserRouter as Router,
  Route,
  Routes,
} from "react-router-dom";
import FormPage from './Components/FormPage'
import LoginPage from './Components/LoginPage';
import Header from './Components/Header';

function App() {
  return (
    <Router>
      <Header></Header>
      <div className="App">
        <Routes>
          <Route exact path="/" element={<FormPage></FormPage>}></Route>
          <Route exact path="/login" element={<LoginPage></LoginPage>}></Route>
        </Routes>
      </div>
    </Router>
  );
}

export default App;
