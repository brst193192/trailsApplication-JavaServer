package com.example.server_side.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.server_side.Converters.TrailConverter;
import com.example.server_side.DTO.TrailDTO;
import com.example.server_side.Models.Favorite;
import com.example.server_side.Models.Trail;
import com.example.server_side.Models.User;
import com.example.server_side.Repository.FavoriteRepository;
import com.example.server_side.Repository.TrailRepository;
import com.example.server_side.Repository.UserRepository;

@Service
public class FavoriteService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FavoriteRepository favoriteRepository;
    @Autowired
    private TrailRepository trailRepository;
    @Autowired
    private TrailConverter trailConverter;

    public List<TrailDTO> getByUserId(int userId) {
        List<Trail> trails = favoriteRepository.findAll().stream()
                .filter(favorite -> favorite.getUser().getId() == userId)
                .map(f -> f.getTrail())
                .collect(Collectors.toList());
        return trailConverter.ManyToTrailDTO(trails);
    }

    public void changeStatus(int userId, int trailId) {
        Favorite favorite = favoriteRepository.getByUserIdAndTrailId(userId, trailId);
        if (favorite != null) {
            favoriteRepository.deleteById(favorite.getId());
        } else {
            User user = userRepository.findById(userId).get();
            Trail trail = trailRepository.findById(trailId).get();
            if (user == null || trail == null) {
                throw new RuntimeException("User or Trail not found");
            }
            favorite = new Favorite();
            favorite.setTrail(trail);
            favorite.setUser(user);
            favoriteRepository.save(favorite);
        }
    }

    public List<TrailDTO> getHot() {
        // יש לבדוק עבור כל טיול כמה פעמים מופיע במועדפים
        // ישלהחזיר את 5 הטיולים שמופיעים הכי הרבה
        List<Favorite> allFavorites = favoriteRepository.findAll();
        if (allFavorites.size() <= 5)
            return allFavorites.stream()
                    .map(favorite -> trailConverter.toTrailDTO(favorite.getTrail())).collect(Collectors.toList());
        // כמה פעמים מופיע כל טיול במועדפים
        List<Trail> allTrails = trailRepository.findAll();
        int[] counter = new int[allTrails.size()];
        for (Favorite f : allFavorites) {
            for (int i = 0; i < allTrails.size(); i++) {
                if (allTrails.get(i).getId() == f.getTrail().getId()) {
                    counter[i]++;
                    break;
                }
            }
        }
        List<Trail> hotTrails = new ArrayList<>();
        int max = 0;
        int imax = -1;
        // מציאת חמשת החמים ביותר
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < allTrails.size(); j++)
                if (counter[j] > max) {
                    max = counter[j];
                    imax = j;
                }
            hotTrails.add(allTrails.get(imax));
            max = 0;
            counter[imax] = 0;
            imax = -1;
        }
        return hotTrails.stream()
                .map(trail -> trailConverter.toTrailDTO(trail)).collect(Collectors.toList());
    }
}
