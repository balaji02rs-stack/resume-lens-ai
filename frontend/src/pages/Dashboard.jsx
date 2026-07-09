import { Link, useNavigate } from "react-router-dom";

function Dashboard() {
  const navigate = useNavigate();

  const handleLogout = () => {
    localStorage.removeItem("token");
    navigate("/");
  };

  return (
    <div className="container mt-5">

      <div className="d-flex justify-content-between align-items-center mb-4">
        <h2>ResumeLens AI Dashboard</h2>

        <button
          className="btn btn-danger"
          onClick={handleLogout}
        >
          Logout
        </button>
      </div>

      <div className="row">

        <div className="col-md-6 mb-4">
          <div className="card shadow h-100">
            <div className="card-body">
              <h4>📄 Upload Resume</h4>

              <p>
                Upload your resume for analysis.
              </p>

              <Link
                to="/upload"
                className="btn btn-primary"
              >
                Open
              </Link>
            </div>
          </div>
        </div>

        <div className="col-md-6 mb-4">
          <div className="card shadow h-100">
            <div className="card-body">
              <h4>📜 Resume History</h4>

              <p>
                View previously analyzed resumes.
              </p>

              <Link
                to="/history"
                className="btn btn-success"
              >
                Open
              </Link>
            </div>
          </div>
        </div>

      </div>

    </div>
  );
}

export default Dashboard;