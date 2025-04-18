// Window 
#ifndef WINDOW_H
#define WINDOW_H

#include <string>

#include <FL/Fl.H>
#include <FL/Fl_Window.H>
#include <FL/Fl_Group.h>
#include <FL/Fl_Dial.H>
#include <FL/Fl_Menu_Bar.H>

#include "Mixer.h"

// Macros for window sizes n stuff
#define MIXER_HEIGHT 200


namespace UI {
	class Window : public Fl_Window {
	private:
		Fl_Menu_Bar* fileBar;

		Fl_Group* mixerGroup;
		Fl_Group* browserGroup;
		Fl_Group* arrangmentGroup;


		// Menu bar callbacks

	public:
		Window(std::string name, int width, int height, ECMS::Mixer* mixer);


	};

	void menuCallBack(Fl_Widget *w, void* v);
}

#endif