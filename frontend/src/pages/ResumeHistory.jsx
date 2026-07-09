import { useEffect, useState } from "react";
import axios from "axios";

function ResumeHistory() {
  const [history, setHistory] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    loadHistory();
  }, []);

  const loadHistory = async () => {
    try {
      const token = localStorage.getItem("token");

      const response = await axios.get(
        "http://localhost:8080/api/resume/history",
        {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        }
      );

      setHistory(response.data);
    } catch (error) {
      console.error(error);
      alert("Unable to load resume history.");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="container mt-5">

      <h2 className="mb-4">
        Resume History
      </h2>

      {loading ? (
        <div className="alert alert-info">
          Loading...
        </div>
      ) : history.length === 0 ? (
        <div className="alert alert-warning">
          No resumes found.
        </div>
      ) : (
        <div className="card shadow">

          <div className="card-body">

            <table className="table table-striped table-hover">

              <thead className="table-dark">

                <tr>
                  <th>ID</th>
                  <th>File Name</th>
                  <th>ATS Score</th>
                  <th>Job Match</th>
                  <th>Uploaded At</th>
                </tr>

              </thead>

              <tbody>

                {history.map((resume) => (

                  <tr key={resume.id}>

                    <td>{resume.id}</td>

                    <td>{resume.fileName}</td>

                    <td>
                      {resume.atsScore}%
                    </td>

                    <td>
                      {resume.jobMatchScore}%
                    </td>

                    <td>
                      {new Date(resume.uploadedAt).toLocaleString()}
                    </td>

                  </tr>

                ))}

              </tbody>

            </table>

          </div>

        </div>
      )}

    </div>
  );
}

export default ResumeHistory;