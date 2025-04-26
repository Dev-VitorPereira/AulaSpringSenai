document.addEventListener('DOMContentLoaded', () => { 
    // Garante que o JavaScript só execute depois que o HTML for carregado
  
    // 1. Buscar os alunos existentes
    fetch('http://localhost:8080/alunos') 
      .then(response => response.json()) 
      .then(data => {
        const tbody = document.getElementById('aluno-tbody'); 
        data.forEach(aluno => {
          adicionarAlunoNaTabela(aluno); // Usando uma função para adicionar aluno
        });
      })
      .catch(error => {
        console.error('Erro ao buscar alunos:', error);
        alert('Erro ao carregar a lista de alunos.');
      });
  
    // 2. Função para adicionar um aluno na tabela
    function adicionarAlunoNaTabela(aluno) {
      const tbody = document.getElementById('aluno-tbody');
      const tr = document.createElement('tr');
      tr.innerHTML = `
        <td>${aluno.nomeAluno}</td>
        <td>${aluno.emailAluno}</td>
        <td>${aluno.telefoneAluno}</td>
      `;
      tbody.appendChild(tr);
    }
  
    // 3. Cadastrar novo aluno
    const form = document.getElementById('cadastro-form');
    form.addEventListener('submit', function(event) {
      event.preventDefault(); // Impede o comportamento padrão do form (recarregar a página)
  
      const novoAluno = {
        nomeAluno: document.getElementById('nomeAluno').value,
        emailAluno: document.getElementById('emailAluno').value,
        telefoneAluno: document.getElementById('telefoneAluno').value
      };
  
      fetch('http://localhost:8080/alunos', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(novoAluno)
      })
      .then(response => {
        if (response.ok) {
          return response.json();
        }
        throw new Error('Erro ao cadastrar aluno');
      })
      .then(alunoCadastrado => {
        adicionarAlunoNaTabela(alunoCadastrado); // Adiciona o novo aluno na tabela
        form.reset(); // Limpa o formulário
        alert('Aluno cadastrado com sucesso!');
      })
      .catch(error => {
        console.error('Erro:', error);
        alert('Não foi possível cadastrar o aluno.');
      });
    });
  
  }); 
  