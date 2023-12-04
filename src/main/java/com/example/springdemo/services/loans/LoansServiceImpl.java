package com.example.springdemo.services.loans;

import org.springframework.stereotype.Service;

import com.example.springdemo.dto.LoansDTO;
import com.example.springdemo.models.Books;
import com.example.springdemo.models.Loans;
import com.example.springdemo.models.Users;
import com.example.springdemo.repositories.BooksRepository;
import com.example.springdemo.repositories.LoansRepository;
import com.example.springdemo.repositories.UsersRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class LoansServiceImpl implements ILoansService {

    private final LoansRepository loansRepository;
    private final UsersRepository usersRepository;
    private final BooksRepository booksRepository;

    public LoansServiceImpl(LoansRepository loansRepository, UsersRepository usersRepository,
            BooksRepository booksRepository) {
        this.loansRepository = loansRepository;
        this.usersRepository = usersRepository;
        this.booksRepository = booksRepository;
    }

    public List<Loans> findAllLoans() {
        return loansRepository.findAll();
    }

    public Loans getLoansById(Long id) {
        return loansRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Emprunt non trouvé avec id : " + id));
    }

    public Loans addLoans(LoansDTO loans) {
        Loans loan = new Loans();
        loan.setLoanDate(LocalDate.now());
        loan.setReturnDate(LocalDate.now().plusDays(30));

        loan.setUser(usersRepository.findById(loans.getUserId())
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé avec id : " + loans.getUserId())));

        loan.setBook(booksRepository.findById(loans.getBookId())
                .orElseThrow(() -> new RuntimeException("Livre non trouvé avec id : " + loans.getBookId())));

        if (!isLoanPossible(loan.getUser(), loan.getBook())) {
            throw new RuntimeException("Emprunt impossible");
        }

        return loansRepository.save(loan);
    }

    public void deleteLoans(Long id) {
        loansRepository.deleteById(id);
    }

    public List<Loans> findAllLoansByUserId(Long userId) {
        return loansRepository.findAllByUserId(userId);
    }

    private boolean isLoanPossible(Users user, Books book) {
        return loansRepository.countAllLoansByUserId(user.getId()) < 3 && book.getNumberOfCopies() > 0;
    }

}
