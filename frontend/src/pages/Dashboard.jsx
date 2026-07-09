import { Link, useNavigate } from "react-router-dom";

function Dashboard() {
  const navigate = useNavigate();

  const handleLogout = () => {
    localStorage.removeItem("token");
    navigate("/");
  };

  return (
    <div className="container py-5">

      <div className="d-flex justify-content-between align-items-center mb-5">

        <div>
          <h2 className="fw-bold">
            ResumeLens AI
          </h2>

          <p className="text-muted mb-0">
            AI Powered Resume Analyzer
          </p>
        </div>

        <button
          className="btn btn-outline-danger"
          onClick={handleLogout}
        >
          Logout
        </button>

      </div>

      <div className="mb-5">

        <h3>
          Welcome Back 👋
        </h3>

        <p className="text-muted">
          Select one of the modules below.
        </p>

      </div>

      <div className="row g-4">

        <div className="col-md-6">

          <div className="card shadow-sm h-100">

            <div className="card-body">

              <h4>📄 Upload Resume</h4>

              <p>
                Upload your resume and receive an ATS score, job match analysis, and extracted skills.
              </p>

              <Link
                className="btn btn-primary"
                to="/upload"
              >
                Open
              </Link>

            </div>

          </div>

        </div>

        <div className="col-md-6">

          <div className="card shadow-sm h-100">

            <div className="card-body">

              <h4>📜 Resume History</h4>

              <p>
                Review all previously analyzed resumes and their scores.
              </p>

              <Link
                className="btn btn-success"
                to="/history"
              >
                Open
              </Link>

            </div>

          </div>

        </div>

        <div className="col-md-6">

          <div className="card shadow-sm h-100">

            <div className="card-body">

              <h4>🤖 AI Resume Analysis</h4>

              <p>
                Analyze resumes using ATS scoring and job description matching.
              </p>

            </div>

          </div>

        </div>

        <div className="col-md-6">

          <div className="card shadow-sm h-100">

            <div className="card-body">

              <h4>🔐 Secure Authentication</h4>

              <p>
                Protected using JWT authentication and Spring Security.
              </p>

            </div>

          </div>

        </div>

      </div>

      <hr className="my-5"/>

      <div className="text-center text-muted">

        <small>

          ResumeLens AI

          <br/>

          Spring Boot • React • PostgreSQL • JWT

        </small>

      </div>

    </div>
  );
}

export default Dashboard;