package com.tricure.backend.controller;

import com.tricure.backend.entity.*;
import com.tricure.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class CmsController {

    @Autowired private ServiceRepository serviceRepository;
    @Autowired private TeamMemberRepository teamMemberRepository;
    @Autowired private TestimonialRepository testimonialRepository;
    @Autowired private FaqRepository faqRepository;
    @Autowired private InquiryRepository inquiryRepository;

    // --- Services ---
    @GetMapping("/services")
    public List<Service> getAllServices() { return serviceRepository.findAll(); }
    @PostMapping("/services")
    public Service createService(@RequestBody Service service) { return serviceRepository.save(service); }
    @PutMapping("/services/{id}")
    public Service updateService(@PathVariable Long id, @RequestBody Service service) {
        service.setId(id);
        return serviceRepository.save(service);
    }
    @DeleteMapping("/services/{id}")
    public void deleteService(@PathVariable Long id) { serviceRepository.deleteById(id); }

    // --- Team Members ---
    @GetMapping("/team")
    public List<TeamMember> getAllTeam() { return teamMemberRepository.findAll(); }
    @PostMapping("/team")
    public TeamMember createTeamMember(@RequestBody TeamMember member) { return teamMemberRepository.save(member); }
    @PutMapping("/team/{id}")
    public TeamMember updateTeamMember(@PathVariable Long id, @RequestBody TeamMember member) {
        member.setId(id);
        return teamMemberRepository.save(member);
    }
    @DeleteMapping("/team/{id}")
    public void deleteTeamMember(@PathVariable Long id) { teamMemberRepository.deleteById(id); }

    // --- Testimonials ---
    @GetMapping("/testimonials")
    public List<Testimonial> getAllTestimonials() { return testimonialRepository.findAll(); }
    @PostMapping("/testimonials")
    public Testimonial createTestimonial(@RequestBody Testimonial testimonial) { return testimonialRepository.save(testimonial); }
    @DeleteMapping("/testimonials/{id}")
    public void deleteTestimonial(@PathVariable Long id) { testimonialRepository.deleteById(id); }

    // --- FAQs ---
    @GetMapping("/faqs")
    public List<Faq> getAllFaqs() { return faqRepository.findAll(); }
    @PostMapping("/faqs")
    public Faq createFaq(@RequestBody Faq faq) { return faqRepository.save(faq); }
    @PutMapping("/faqs/{id}")
    public Faq updateFaq(@PathVariable Long id, @RequestBody Faq faq) {
        faq.setId(id);
        return faqRepository.save(faq);
    }
    @DeleteMapping("/faqs/{id}")
    public void deleteFaq(@PathVariable Long id) { faqRepository.deleteById(id); }

    // --- Inquiries ---
    @GetMapping("/inquiries")
    public List<Inquiry> getAllInquiries() { return inquiryRepository.findAll(); }
    @PostMapping("/inquiries")
    public Inquiry createInquiry(@RequestBody Inquiry inquiry) { return inquiryRepository.save(inquiry); }
    @PutMapping("/inquiries/{id}/read")
    public Inquiry markInquiryRead(@PathVariable Long id) {
        Inquiry inquiry = inquiryRepository.findById(id).orElseThrow();
        inquiry.setRead(true);
        return inquiryRepository.save(inquiry);
    }
}
